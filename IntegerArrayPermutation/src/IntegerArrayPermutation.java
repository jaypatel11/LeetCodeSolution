import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/16/13
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegerArrayPermutation {

    public static void main(String args[]){


        int num[] = {1,1,3};
        System.out.println(intPermutation(num));


    }

    private static ArrayList<ArrayList<Integer>> intPermutation(int[] num) {


        ArrayList<Integer> intList = new ArrayList<Integer>(num.length);

        for (int i=0; i<num.length; i++)
        {
            intList.add(num[i]);
        }
        return intPermutationHelper(intList);
    }

    private static ArrayList<ArrayList<Integer>> intPermutationHelper(ArrayList<Integer> numbers) {

        ArrayList<ArrayList<Integer>> newPermutationList = new ArrayList<ArrayList<Integer>>();

        if(numbers.size() == 0){


            ArrayList<Integer> empty = new ArrayList<Integer>();
            newPermutationList.add(empty);
            return newPermutationList;
        }


        int firstEntry = numbers.get(0);
        numbers.remove(0);
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        remaining.addAll(numbers);
        ArrayList<ArrayList<Integer>> permutationList = intPermutationHelper(remaining);
        for (ArrayList<Integer> currentPerm : permutationList) {

            for(int i = 0; i <= currentPerm.size(); i++){

                ArrayList<Integer> newPerm = insertInt(firstEntry, currentPerm, i );
                if(!newPermutationList.contains(newPerm))
                newPermutationList.add(newPerm);
            }

        }
        return newPermutationList;




    }

    private static ArrayList<Integer> insertInt(int firstEntry, ArrayList<Integer> numbers, int pos) {

        ArrayList<Integer> newPerm = new ArrayList<Integer>();


        for(int i = 0; i < pos; i++){

            newPerm.add(numbers.get(i));
        }

        newPerm.add(firstEntry);

        for(int i = pos; i < numbers.size(); i++){

            newPerm.add(numbers.get(i));
        }
        return newPerm;
    }


}
