import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/10/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbStairs {


    private static int climbHelper( int n, int map[]){


        if(map[n-1] > 0)
            return map[n-1];


        map[n-1] = climbHelper(n-1, map) + climbHelper(n-2, map);

        return map[n-1];
    }

    static int climb(int n){
        if( n == 0 || n == 1){

            return 1;
        }
        int map[] = new int[n];
        map[0]  = 1;
        map[1] = 2;

        return climbHelper(n, map);

    }
    public static void main(String args[]){

          System.out.println(climb(1));
    }
}

