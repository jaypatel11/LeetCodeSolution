import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/16/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class NeedleHaystack {

    public static void main(String args[]){


        System.out.println(findNeedle("ababbbbaaabbbaaa", "bbbb"));
        System.out.println(findNeedle("jim saw me in a barber parlour", "barber"));

        System.out.println(findNeedle("mississippi", "issipi"));
        System.out.println(findNeedle("bbbbababbbaabbba", "abb"));


    }

    private static String findNeedle(String text, String pattern) {


        int m = pattern.length();
        int n = text.length();

        if(m == 0)
            return text;

        if(m > n)
            return null;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for( char key = 'a'; key <= 'z'; key++){

            map.put(key, m);
        }
        //Space
        map.put(' ', m);


        for(int j = 0; j < m-1; j++){

            map.put(pattern.charAt(j), m-1-j);
        }

        String found = null;
        int textIndex  = 0;

        while(textIndex + m -1< n){

            int currentIndex = m-1;
            int textIndexDeduct = 0;
            char lastMatch = '\0';
            while(currentIndex >= 0 && text.charAt(textIndex + m -1 - textIndexDeduct) == pattern.charAt(currentIndex)){

                lastMatch = pattern.charAt(currentIndex);

                currentIndex --;
                textIndexDeduct++;
            }

            if(currentIndex < 0){

                found  = text.substring(textIndex);
                break;
            }

            /*if(textIndex + m-1 == n-1)
                break;*/

            if(textIndexDeduct > 0)
                textIndex+= map.get(lastMatch) ;

            else
                textIndex+= map.get(text.charAt(textIndex +m -1 - textIndexDeduct));


        }

        return found;

    }

}
