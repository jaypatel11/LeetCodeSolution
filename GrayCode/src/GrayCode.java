import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/13/13
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrayCode {


    public static void main(String args[]){


        System.out.println(grayCode(3));
    }

    public static ArrayList<Integer> grayCode(int n) {


        int total = (int) Math.pow(2.0,n);
        ArrayList<Integer> solution = new ArrayList<Integer>();
        for(int i = 0; i < total; i++){

             solution.add(i^(i/2));

        }

        return solution;
    }
}
