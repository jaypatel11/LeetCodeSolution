import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/10/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Combinations {


    public static void main( String args[]){


        System.out.println(combine(4,2));

    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {


        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        combineHelper( n,  k, 0, new ArrayList<Integer>(), solution);
        return solution;
    }

    private static void combineHelper(int n, int k, int index, ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> solution) {


        if(comb.size() == k){

             solution.add(comb);
             return;
        }

        for(int i = index; i < n; i++){

            ArrayList<Integer> tempSol = new ArrayList<Integer>(comb);


            tempSol.add(i+1);
            System.out.println(tempSol);

            combineHelper(n, k, i+1, tempSol, solution);

        }
    }
}
