/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/5/14
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pangram {


    public static void main(String args[]){


        System.out.println(isPangram("the quick brown fox jumps over the lazy dog"));//true
        System.out.println(isPangram("the quick brown fox jumped over the lazy dog"));//false, no s
        System.out.println(isPangram("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));//true
        System.out.println(isPangram("ABCDEFGHIJKLMNOPQSTUVWXYZ"));//false, no r
        System.out.println(isPangram("ABCDEFGHIJKL.NOPQRSTUVWXYZ"));//false, no m
        System.out.println(isPangram("ABC.D.E.FGHI*J/KL-M+NO*PQ R\nSTUVWXYZ"));//true
        System.out.println(isPangram(""));

        isPangramLinearSpace("the quick brown fox jumps over the lazy dog");//true
       isPangramLinearSpace("the quick brown fox jumped over the lazy dog");;//false, no s
        isPangramLinearSpace("ABCDEFGHIJKLMNOPQRSTUVWXYZ");//true
        isPangramLinearSpace("ABCDEFGHIJKLMNOPQSTUVWXYZ");//false, no r
       isPangramLinearSpace("ABCDEFGHIJKL.NOPQRSTUVWXYZ");//false, no m
        isPangramLinearSpace("ABC.D.E.FGHI*J/KL-M+NO*PQ R\nSTUVWXYZ");//true
    }

    private static boolean isPangram(String input) {


        if( input == null || input.isEmpty())
            return true;

        for( char current = 'a'; current <= 'z'; current++){

            if(input.indexOf(current) < 0 && input.indexOf((char)(current - 32)) <0)
                return false;
        }

        return true;
    }


    private static void isPangramLinearSpace(String input) {


        if( input == null || input.isEmpty())
            return;

        boolean charMap[] = new boolean[26];
        input = input.toLowerCase();
        for( int i = 0; i < input.length(); i++){

            if(input.charAt(i)>='a' && input.charAt(i)<='z')
                charMap[input.charAt(i)-'a'] = true;
        }

        for(int i = 0; i < charMap.length; i++){

            if(charMap[i] == false)
                System.out.print((char)(i+97) +" ");
        }

        System.out.println();

    }
}

