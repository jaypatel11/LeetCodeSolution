import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/10/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {

    public static void main( String args[]){

       int candidates[] ={2,3,6,7};
       int target = 9;
       System.out.println(comboSum(candidates, target));
    }

    private static ArrayList<ArrayList<Integer>> comboSum(int[] candidates, int target) {

        ArrayList<ArrayList<Integer>> matchingCandidates = new ArrayList<ArrayList<Integer>>();

        comboSumHelper(candidates, 0, target, new ArrayList<Integer>(), matchingCandidates, 0);


        return matchingCandidates;
    }

    private static void comboSumHelper(int[] candidates, int sum, int target, ArrayList<Integer> currentCombo,
                    ArrayList<ArrayList<Integer>> matchingCandidates, int index) {

        System.out.println(currentCombo);
        if(sum > target)
            return;

        if( target == sum){

            matchingCandidates.add(currentCombo);

            return;

        }

        for(int i = index; i < candidates.length; i++){

            ArrayList<Integer> temp = new ArrayList<Integer>(currentCombo);

            temp.add(candidates[i]);
            comboSumHelper(candidates, sum + candidates[i], target, temp, matchingCandidates, i);


        }


    }



}


