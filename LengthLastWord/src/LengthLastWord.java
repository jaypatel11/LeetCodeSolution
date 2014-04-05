/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/19/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class LengthLastWord {

    public static void main(String args[]){

        String s = "Hello word     ";
        System.out.println(lengthLastWord(s));
    }

    private static int lengthLastWord(String s) {

        int i;
        int len = 0;
        for(i = s.length() -1; i>=0; i--){

           if(s.charAt(i) == ' ')
               continue;
            else break;
        }


        for(int k = i; k >= 0; k-- ){

            if(s.charAt(k) == ' ')
                break;

            else len++;
        }

        return len;
    }

}
