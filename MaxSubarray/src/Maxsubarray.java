/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/20/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Maxsubarray {

    public static void main(String args[]){


        int numbers[] = {0,1,2};

        System.out.println(maxSubarray(numbers));
    }

    private static int maxSubarray(int[] numbers) {

        int max = Integer.MIN_VALUE;
        int max_till_here = 0;

        for( int i = 0; i < numbers.length; i++) {

            max_till_here += numbers[i];

            if(max_till_here < 0){


                max_till_here = 0;
                max = Math.max(max, numbers[i]);

            }
            else
                max = Math.max(max, max_till_here);

        }

        return max;
    }
}
