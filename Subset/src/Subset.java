import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/14/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subset {

    public static void main(String args[]){

        int set[] ={1,2,3};
        System.out.println(generateSubsetsCombinatorial(set));
    }

    private static ArrayList<ArrayList<Integer>> generateSubsets(int[] set) {

        ArrayList<ArrayList<Integer>> subsets = generateSubsetsHelper(set, 0);
        return subsets;
    }

    private static ArrayList<ArrayList<Integer>> generateSubsetsHelper(int[] set, int index) {


        if(index == set.length){

            ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }



        ArrayList<ArrayList<Integer>> subset  = generateSubsetsHelper(set, index +1);
        ArrayList<ArrayList<Integer>> finalsubset = new ArrayList<ArrayList<Integer>>();
        finalsubset.addAll(subset);
        for(int i = 0; i < subset.size(); i++){


            ArrayList<Integer> currentSubset = subset.get(i);

            ArrayList<Integer> moreSubsets = new ArrayList<Integer>();
            moreSubsets.addAll(currentSubset);
            moreSubsets.add(set[index]);

            Collections.sort(moreSubsets);
            if(!finalsubset.contains(moreSubsets))
                finalsubset.add(moreSubsets);

        }

        return finalsubset;

    }

    private static ArrayList<ArrayList<Integer>> generateSubsetsCombinatorial(int[] set) {


        int total = (int)Math.pow(2, set.length);

        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        for( int i = 0; i < total; i++){

             subsets.add(generateSubsetsCombinatorialHelper(i, set));
        }

        return subsets;

    }

    private static ArrayList<Integer> generateSubsetsCombinatorialHelper(int i, int[] set) {

        ArrayList<Integer> currentSubset = new ArrayList<Integer>();

        for(int k = 0;  k < set.length; k++){



            if((i>>k & 1) == 1){

                 currentSubset.add(set[k]);
            }
        }

        return currentSubset;
    }
}