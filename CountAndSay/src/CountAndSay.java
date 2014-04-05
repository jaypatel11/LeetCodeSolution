/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/13/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
/*
The count-and-say sequence is the sequence of integers beginning as follows:
        1, 11, 21, 1211, 111221, ...

        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.*/
public class CountAndSay {
    
    
    public static void main(String args[]){
        
        
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {


        if(n < 1)
            return "0";
        if(n == 1)
            return "1";

        String ans = countAndSayHelper(n, 1, "1");

        return ans;
    }

    private static String countAndSayHelper(int n, int count, String calc) {

        if( count == n)
            return calc;

        int charCount = 1;
        int i =0 ;
        String ans = "";
        for( i=1; i < calc.length(); i++)
        {

             if(calc.charAt(i-1) == calc.charAt(i)){

                 charCount++;
             }

             else{

                    ans += Integer.toString(charCount)+ calc.charAt(i-1);
                    charCount = 1;
             }

        }

        ans += Integer.toString(charCount)+ calc.charAt(i-1);

        String answer = countAndSayHelper(n, ++count, ans);

        return answer;

    }
}
