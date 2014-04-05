import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/19/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneCombination {

    public static void main(String args[]){

        String s = "237";
        System.out.println(phoneCombination(s));
    }

    private static ArrayList<String> phoneCombination(String s) {


        ArrayList<String> currentCombination = null;
        if(s.length() == 0){

            currentCombination = new ArrayList<String>();
            currentCombination.add(new String());
            return currentCombination;
        }


        currentCombination = phoneCombination(s.substring(1));

        ArrayList<String> newCombination = new ArrayList<String>();

        for( String word : currentCombination){

            String letters = getNumberLetters(s.charAt(0));

            for( int i = 0 ; i < letters.length(); i++){


                String newWord = letters.charAt(i) + word;
                newCombination.add(newWord);


            }


        }

        return newCombination;

    }

    private static String getNumberLetters(char number ){

        switch (number){

            case '1':
                return "";

            case '2':
                return "abc";

            case '3':
                return "def";

            case '4':
                return "ghi";

            case '5':
                return "jkl";

            case '6':
                return "mno";

            case '7':
                return "pqrs";

            case '8':
                return "tuv";

            case '9':
                return "wxyz";

            case '0':
                return " ";
        }
        return "";


    }



}
