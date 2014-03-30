import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/19/13
 * Time: 1:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class LargestRectangle {


    public static void main(String args[]){

        int[] A = {2,1,5,6,2,3};
        System.out.println(findLargestRectangle(A));
    }

    private static int findLargestRectangle(int[] height) {

        if(height == null )
            return 0;

        if(height.length == 1)
            return height[0];

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        int maxArea = 0;

        while( i < height.length){

            if(stack.empty() || height[stack.peek()] <= height[i] ){


                stack.push(i++);
            }

            else{


                int topPointer = stack.peek();
                stack.pop();

                int area = height[topPointer]*(stack.empty()? i : i-1-stack.peek());

                maxArea = Math.max(maxArea, area);
            }

        }
        while (!stack.empty()){

            int topPointer = stack.peek();
            stack.pop();

            int area = height[topPointer]*(stack.empty()? i : i-1-stack.peek());

            maxArea = Math.max(maxArea, area);

        }
        return maxArea;


    }
}
