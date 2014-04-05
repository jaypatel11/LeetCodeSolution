import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/7/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSumClosest {


    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length:");
        int length = in.nextInt();

        int a[] = new int[length];

        System.out.println("Enter elements");

        for(int i = 0; i < length; i++){

            a[i] = in.nextInt();
        }
        System.out.println("Enter target");
        int target = in.nextInt();



        System.out.println("Closest:"+threeSumClosest(a,target));

    }

    public static int threeSumClosest(int[] input, int target) {

        int closest = input[0] + input[1]+input[2];

        for(int i = 0 ; i < input.length - 2; i++){

            for(int j = i+ 1; j < input.length -1; j++){

                for(int k = j +1; k < input.length; k++){

                    if ( Math.abs(input[i] + input[j] + input[k] - target)   <= Math.abs(closest-target)){

                        closest = input[i] + input[j]+ input[k];

                    }

                }

            }
        }
        return  closest;
    }
}
