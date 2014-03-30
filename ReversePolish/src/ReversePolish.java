import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/13/13
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
/*
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
public class ReversePolish {


    public static void main(String args[]){

        String tokens[] ={"2", "1", "+", "3", "*"};

        System.out.println(evalRPN(tokens));

    }

    public static int evalRPN(String[] tokens) {


        Stack<String> stack = new Stack<String>();
        int operand1;
        int operand2;
        int tempAnswer;

        for(int i =0 ; i < tokens.length; i++){

            if(!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))){

                stack.push(tokens[i]);
            }
            else{

                operand2 = Integer.parseInt(stack.pop());
                operand1 = Integer.parseInt(stack.pop());
                tempAnswer = performOperation(operand1, operand2, tokens[i].charAt(0));
                stack.push(Integer.toString(tempAnswer));
            }

        }

        return Integer.parseInt(stack.pop());
    }

    private static int performOperation(int operand1, int operand2, char operator) {


        int answer = 0;
        switch (operator){

            case '+':
                answer =  operand1 + operand2;
                break;
            case '-':
                answer =  operand1 - operand2;
                break;
            case '*':
                answer =  operand1 * operand2;
                break;
            case '/':
                answer =  operand1 / operand2;
                break;
            default:
                System.out.println("Invalid operand");

        }

        return answer;
    }
}
