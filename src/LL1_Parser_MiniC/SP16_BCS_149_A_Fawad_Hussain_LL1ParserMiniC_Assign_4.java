package LL1_Parser_MiniC;
import java.util.Stack;


public class SP16_BCS_149_A_Fawad_Hussain_LL1ParserMiniC_Assign_4 {

    enum terminals{
        ID,Num,While,If,Else,Int,Float,LCB,RCB,LRB,RRB,Colon,Minus,Plus,Asterik,LSlash,Equal,LT,GT,LEqual,GEqual,NotEqual,EqualEqual,Dollar;
    }
    enum nonTerminals {
        Stmt,StmtDash,StmtDDash,Declaration,Type,WhileStmt,IfStmt,IfStmtDash,ElsePart,CompoundStmt,CompoundStmtDash,StmtList,
        StmtListDash,StmtListDDash,StmtListTDash,BoolExpr,Compare,Expr,Mag,MagDash,MagDDash,Term,TermDash,Factor;
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String inputString;
        String output;

        String[][] table=
               {
                       //Stmt
                       {"Expr ;","scan","while ( BoolExpr ) Stmt","if ( BoolExpr ) Stmt Stmt’’","POP","Type identifier ;","Type identifier ;","{ Stmt'","POP","scan","scan",";","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","POP"},

                        //Stmt'
                       {"StmtList }","scan","StmtList }","StmtList }","POP","StmtList }","StmtList }","StmtList }","}","scan","scan","StmtList }","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","POP"},

                       //Stmt''
                       { "Expr ;","scan","e","e","ElsePart","e","e","e","e","scan","scan","e","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","e"},

                        //Declaration
                       {"scan","scan","scan","scan","scan","Type identifier ;","Type identifier ;","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Type
                       {"POP","scan","scan","scan","scan","int","float","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //WhileStmt
                       {"scan","scan","while ( BoolExpr ) Stmt","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //IfStmt
                       {"scan","scan","scan","if ( BoolExpr ) Stmt  IfStmt’","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //IfStmt'
                       {"scan","scan","scan","scan","ElsePart","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //ElsePart
                       {"POP","scan","POP","POP","else Stmt","POP","POP","POP","POP","scan","scan","POP","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","POP"},

                       //CompoundStmt
                       {"scan","scan","scan","scan","scan","scan","scan","{ CompoundStmt’","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //CompoundStmt'
                       {"StmtList }","scan","StmtList }","StmtList }","scan","StmtList }","StmtList }","StmtList }","StmtList }","scan","scan","StmtList }","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //StmtList
                       {"Expr ; StmtList’","scan","while ( BoolExpr ) Stmt StmtList’","if ( BoolExpr ) Stmt StmtList’’’","scan","Type identifier ; StmtList’","Type identifier ; StmtList’","{ StmtList’’","POP","scan","scan","; StmtList’","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //StmtList'
                       {"Stmt StmtList’","scan","Stmt StmtList’","Stmt StmtList’","scan","Stmt StmtList’","Stmt StmtList’","Stmt StmtList’","e","scan","scan","Stmt StmtList’","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //StmtList''
                       {"StmtList } StmtList’","scan","StmtList } StmtList’","StmtList } StmtList’","scan","StmtList } StmtList’","StmtList } StmtList’","StmtList } StmtList’","} StmtList’","scan","scan","StmtList } StmtList’","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //StmtList'''
                       {"StmtList’","scan","StmtList’","StmtList’","ElsePart Stmtlist’","StmtList’","StmtList’","StmtList’","e","scan","scan","StmtList’","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //BoolExpr
                       {"identifier Compare Mag","scan","scan","scan","scan","scan","scan","scan","scan","scan","POP","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Compare
                       {"POP","POP","scan","scan","scan","scan","scan","scan","scan","POP","scan","scan","scan","scan","scan","scan","scan","<",">","<=",">=","<>","==","scan"},

                        //Expr
                       {"identifier = Mag","scan","scan","scan","scan","scan","scan","scan","scan","scan","POP","POP","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                       //Mag
                       {"Term Mag’’","Term Mag’’","scan","scan","scan","scan","scan","scan","scan","Term Mag’’","POP","POP","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Mag'
                       {"scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","e","e","- Term Mag'","+ Term Mag'","scan","scan","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Mag''
                       {"scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","POP","POP","scan","scan","* Factor Mag’","/ Factor Mag’","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Term
                       {"identifier Term’","number Term","scan","scan","scan","scan","scan","scan","scan","( Expr ) Term’","POP","POP","POP","POP","POP","POP","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Term'
                       {"scan","scan","scan","scan","scan","scan","scan","scan","scan","scan","e","e","- Term Mag'","+ Term Mag'","* Factor Term’","/ Factor Term’","scan","scan","scan","scan","scan","scan","scan","scan"},

                        //Factor
                       {"identifier","number","scan","scan","scan","scan","scan","scan","scan","( Expr )","POP","POP","POP","POP","POP","POP","scan","scan","scan","scan","scan","scan","scan","scan"}

                };

        stack.push("$");
        stack.push("Stmt");

        inputString = "if ( identifier > identifier ) identifier = identifier ; else identifier = identifier ; $";

        String[] inputArr;
        inputArr = inputString.split(" ");
        String temp;
        int inputArrIndex = 0;
        String curInputStrValue;
        while (!stack.empty()) {
            temp = stack.pop();
            curInputStrValue = inputArr[inputArrIndex];

            System.out.print( "\n" + "Top of Stack: ");
            System.out.println(temp);
            System.out.print("Current Input String value: ");
            System.out.println(curInputStrValue);

            if(temp.equals("$") && !temp.equals(curInputStrValue))
            {
                System.out.print("\n" + "Pushing Root Again into stack!");
                stack.push("$");
                stack.push("Stmt");
            }
            else
             {
                if (curInputStrValue.equals(temp))
                {
                    System.out.println("---Output When Matched--- ");
                    System.out.println("String Value Matched: " + temp);
                    inputArrIndex++;
                }
                else
                    {

//                System.out.println("\n" + temp);
//                System.out.println(getNonTerminal(temp).ordinal());
//                System.out.println(getTerminal(inputArr[inputArrIndex]));
//                System.out.println(getTerminal(inputArr[inputArrIndex]).ordinal() + "\n" );
                    String tempp;
                    output = table[getNonTerminal(temp).ordinal()][getTerminal(inputArr[inputArrIndex]).ordinal()];
                    if (output.equals("scan"))
                    {
                        inputArrIndex++;
                    }
                    else if (output.equals("e"))
                    {
                        tempp = stack.pop();
                    }
                    else if (output.equals("POP"))
                    {
                        tempp = stack.pop();
                    }
                    else
                    {
                        String[] outputArr = output.split(" ");
                        System.out.println("---Output when Non Terminal--- ");
                        System.out.println(getNonTerminal(temp) + " -> " + output);
                        for (int i = outputArr.length - 1; i >= 0; i--)
                        {
                            stack.push(outputArr[i] + "");
                        }
                    }
                }
            }
        }
    }

    public static nonTerminals getNonTerminal(String ch) {
        if(ch.equals("Stmt"))
            return nonTerminals.Stmt;
        if(ch.equals("Stmt’"))
            return nonTerminals.StmtDash;
        if(ch.equals("Stmt’’"))
            return nonTerminals.StmtDDash;
        if(ch.equals("Declaration"))
            return nonTerminals.Declaration;
        if(ch.equals("Type"))
            return nonTerminals.Type;
        if(ch.equals("WhileStmt"))
            return nonTerminals.WhileStmt;
        if(ch.equals("IfStmt"))
            return nonTerminals.IfStmt;
        if(ch.equals("IfStmt’"))
            return nonTerminals.IfStmtDash;
        if(ch.equals("ElsePart"))
            return nonTerminals.ElsePart;
        if(ch.equals("CoumpoundStmt"))
            return nonTerminals.CompoundStmt;
        if(ch.equals("CoumpoundStmt’"))
            return nonTerminals.CompoundStmtDash;
        if(ch.equals("StmtList"))
            return nonTerminals.StmtList;
        if(ch.equals("StmtList’"))
            return nonTerminals.StmtListDash;
        if(ch.equals("StmtList’’"))
            return nonTerminals.StmtListDDash;
        if(ch.equals("StmtList’’’"))
            return nonTerminals.StmtListTDash;
        if(ch.equals("BoolExpr"))
            return nonTerminals.BoolExpr;
        if(ch.equals("Compare"))
            return nonTerminals.Compare;
        if(ch.equals("Expr"))
            return nonTerminals.Expr;
        if(ch.equals("Mag"))
            return nonTerminals.Mag;
        if(ch.equals("Mag’"))
            return nonTerminals.MagDash;
        if(ch.equals("Mag’’"))
            return nonTerminals.MagDDash;
        if(ch.equals("Term"))
            return nonTerminals.Term;
        if(ch.equals("Term’"))
            return nonTerminals.TermDash;
        if(ch.equals("Factor"))
            return nonTerminals.Factor;
        return null;
    }

    public static terminals getTerminal(String ch) {
        if(ch.equals("identifier"))
            return terminals.ID;
        if(ch.equals("number"))
            return terminals.Num;
        if(ch.equals("while"))
            return terminals.While;
        if(ch.equals("if"))
            return terminals.If;
        if(ch.equals("else"))
            return terminals.Else;
        if(ch.equals("int"))
            return terminals.Int;
        if(ch.equals("float"))
            return terminals.Float;
        if(ch.equals("{"))
            return terminals.LCB;
        if(ch.equals("}"))
            return terminals.RCB;
        if(ch.equals("("))
            return terminals.LRB;
        if(ch.equals(")"))
            return terminals.RRB;
        if(ch.equals(";"))
            return terminals.Colon;
        if(ch.equals("-"))
            return terminals.Minus;
        if(ch.equals("+"))
            return terminals.Plus;
        if(ch.equals("*"))
            return terminals.Asterik;
        if(ch.equals("/"))
            return terminals.LSlash;
        if(ch.equals("="))
            return terminals.Equal;
        if(ch.equals("<"))
            return terminals.LT;
        if(ch.equals(">"))
            return terminals.GT;
        if(ch.equals("<="))
            return terminals.LEqual;
        if(ch.equals(">="))
            return terminals.GEqual;
        if(ch.equals("<>"))
            return terminals.NotEqual;
        if(ch.equals("=="))
            return terminals.EqualEqual;
        if(ch.equals("$"))
            return terminals.Dollar;
        return null;
    }
}
