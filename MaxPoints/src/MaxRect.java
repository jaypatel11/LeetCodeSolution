import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/3/14
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */

public class MaxRect {

    public static void main(String args[]){

        char matrix[][] =
        {       {'0','1','0','1','0','1'},
                {'1','0','1','0','0','1'},
                {'1','1','1','1','0','1'},
                {'1','1','0','1','0','1'}};

        System.out.println(findMaxSum(matrix));
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

    private static int findMaxSum(char[][] matrix) {

        int maxArea = 0;
        int m  = matrix.length;
        if( m == 0)
            return 0;

        int n = matrix[0].length;

        int lenMatrix[][] = new int[m][n];

        for( int i = 0; i < m; i++){

            for( int j = 0; j < n; j++){

                if(matrix[i][j] == '0')
                    continue;
                else
                    if(i == 0)
                        lenMatrix[i][j]  += matrix[i][j] - '0' ;
                    else
                        lenMatrix[i][j]  += 1 + lenMatrix[i-1][j] ;


            }
        }


        for(int i = 0; i < lenMatrix.length; i++){

            for(int j = 0 ; j < n; j++)

                System.out.print(lenMatrix[i][j] + " ");

            System.out.println();
        }
        for( int i = 0; i < m; i++){

            maxArea = Math.max(maxArea, findLargestRectangle(lenMatrix[i]));
        }

        return maxArea;

    }
}
