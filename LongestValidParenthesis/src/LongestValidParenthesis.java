import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/20/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParenthesis {

    public static void main(String args[]){
                                                        
        String s = ")()())";

        System.out.println(findLongestValidParenthesis(s));
        System.out.println(findLongestValidParenthesis("()()"));
        System.out.println(findLongestValidParenthesis("()(()"));
        System.out.println(findLongestValidParenthesis("(()"));

    }

    private static int findLongestValidParenthesis(String s) {


        Stack<Integer> stack = new Stack<Integer>();

        int count  =0;
        int max =0;
        int i = 0;
        int lastClose = -1;

        while(i < s.length()){

            if(s.charAt(i) == '('){

                stack.push(i);


            }
            else{

                if(stack.empty())
                    // Deals with cases substrings like ()()()
                    lastClose  = i;

                else{


                    stack.pop();
                    if(stack.empty()){

                        // deal with cases when s is ())()()

                        max = Math.max(max, i - lastClose);
                    }
                    else{

                        // deal with cases when s is ()()(((()

                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            i++;

        }
        return  max;
    }
}