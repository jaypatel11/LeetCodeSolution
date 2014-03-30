/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/10/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class MostWater {


    public static void main( String args[]){

        int a[] = {4, 5 , 2, 1, 3};
        System.out.println(mostWater(a));

    }

    private static int mostWater(int[] height) {


        if(height.length < 2)
            return 0;

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while(i < j){

            maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
            if(height[i] < height[j])
                i++;
            else j--;
        }

        return maxArea;
    }
}
