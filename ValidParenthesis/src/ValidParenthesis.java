import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/15/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidParenthesis {

    public static void main(String args[]){


        System.out.println(generateParenthesis(4));


    }

    private static ArrayList<String> generateParenthesis(int n) {


        ArrayList<String> parenthesis = new ArrayList<String>();

        char str[] = new char[n*2];
        generateParenthesisHelper(parenthesis, str, n, n, 0);
        return parenthesis;
    }

    private static void generateParenthesisHelper(ArrayList<String> parenthesis, char[] str, int leftRemaining, int rightRemaining, int count) {

        if( /*leftRemaining > rightRemaining ||*/ leftRemaining < 0)
            return;

        if(leftRemaining ==0 && rightRemaining == 0){

            String solution = new String(str);
            parenthesis.add(solution);

        }

        if(leftRemaining > 0){

            str[count] = '(';
            generateParenthesisHelper(parenthesis, str, leftRemaining -1, rightRemaining, count +1);
        }


        if(rightRemaining > leftRemaining){

            str[count] = ')';
            generateParenthesisHelper(parenthesis, str, leftRemaining , rightRemaining -1, count +1);
        }


    }


}
