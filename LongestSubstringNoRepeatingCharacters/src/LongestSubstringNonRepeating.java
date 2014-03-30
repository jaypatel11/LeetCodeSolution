import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/20/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubstringNonRepeating {

    public static void main(String args[]){

        String s1 = "abbcde";
        String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";

        System.out.println(findLongestSubstring(s1));
        System.out.println(findLongestSubstring(s));
    }

    private static int findLongestSubstring(String s) {

        if( s.length() == 0 || s.length() == 1)
            return s.length();

        HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int  max= 1;
        int count = 0;
        int longestStart = 0;
        int start  = 0;
        int longestEnd = 0;

        for( int i  = 0; i < s.length(); i++){

            if(!charIndexMap.containsKey(s.charAt(i)))
                charIndexMap.put(s.charAt(i) ,i);

        }

        for( int i = 0; i < s.length(); i++){

            char character = s.charAt(i);
            int charIndex = charIndexMap.get(character);

         /*   System.out.println("Longest end:"+longestEnd+" longest start:"+longestStart+" end:"+i+" start:"+i);
         */   if(charIndex < i){


                charIndexMap.put(character, i);
                start = Math.max(start,charIndex+1);

            }
            if(longestEnd - longestStart < i - start){

                longestStart = start;
                longestEnd = i;

            }


        }

        return longestEnd - longestStart+1;



    }
}
