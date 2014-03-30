/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/16/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Candy {

    public static void main(String args[]){

        int ratings[] = {1,2,3,4,5};
        System.out.println(findMinCandy(ratings));


    }

    private static int findMinCandy(int[] ratings) {


        if(ratings.length == 0 )
            return 0;

        int minCandy = ratings.length;
        int cur = 0;
        int candies[] = new int[ratings.length];
        for(int i = 1; i < ratings.length; i++){

            if(ratings[i] > ratings[i-1]){

                cur++;
            }

            else cur =0;

            candies[i]  =cur;

        }


        for(int i = candies.length -2; i >= 0; i--){

            if( ratings[i] > ratings[i+1]){

                cur++;
            }
            else cur =0;

            minCandy += Math.max(candies[i], cur);
        }


        minCandy += candies[candies.length-1];

        return minCandy;
    }

}
