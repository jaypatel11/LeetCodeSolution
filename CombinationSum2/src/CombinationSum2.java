import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/10/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum2 {

    public static void main( String args[]){

        int candidates[] ={1,1};
        int target = 1;
        System.out.println(combinationSum2(candidates, target));
    }

    private static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {

        ArrayList<ArrayList<Integer>> matchingCandidates = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(candidates);
        comboSumHelper(candidates, 0, target, new ArrayList<Integer>(), matchingCandidates, 0);


        return matchingCandidates;
    }

    private static void comboSumHelper(int[] candidates, int sum, int target, ArrayList<Integer> currentCombo,
                                       ArrayList<ArrayList<Integer>> matchingCandidates, int index) {

        //System.out.println(currentCombo);
        if(sum > target)
            return;

        if( target == sum){

            for(int i = 0; i < matchingCandidates.size(); i++){

                    if(matchingCandidates.get(i).size() == currentCombo.size())
                        if(matchingCandidates.get(i).equals(currentCombo))
                            return;
            }
            matchingCandidates.add(currentCombo);

            return;

        }

        for(int i = index; i < candidates.length; i++){


            ArrayList<Integer> temp = new ArrayList<Integer>(currentCombo);
            temp.add(candidates[i]);
            comboSumHelper(candidates, sum + candidates[i], target, temp, matchingCandidates, i+1);


        }


    }



}


