import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/15/13
 * Time: 12:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringPermutation {

    public static void main(String args[]){


        System.out.println(stringPermutation("abc"));


    }

    private static ArrayList<String> stringPermutation(String input) {




        ArrayList<String> permutations = new ArrayList<String>();
        if(input.length() == 0){


            permutations.add(new String());
            return permutations;

        }


        String remainder =  input.substring(1);
        ArrayList<String> currentPerm= stringPermutation(remainder);
        String firstChar = input.charAt(0) +"";
        for(String perm : currentPerm){

            for(int j = 0; j <= perm.length(); j++){

                String word = insertCharAt(firstChar, j, perm);
                permutations.add(word);
            }
        }

        return permutations;


    }

    private static String insertCharAt(String firstChar, int pos, String perm) {

        String firstHalf = perm.substring(0, pos);
        String secondHalf = perm.substring(pos);

        return firstHalf + firstChar + secondHalf;
    }


}
