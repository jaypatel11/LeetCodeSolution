import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/19/13
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestCommonSequence {


    public static void main(String args[]){


        int numbers[] = {0,-1};

        System.out.println(longestCommonSequence(numbers));
    }

    private static int longestCommonSequence(int[] numbers) {

        Set<Integer> numberSet = new TreeSet<Integer>();

        for(int i =0 ; i < numbers.length; i++)
            numberSet.add(numbers[i]);

        int max = 1;
        int consec = 1;

        Iterator it = numberSet.iterator();

        int curr = 0;
        int prev = 0;

        prev = (Integer)it.next();
        while(it.hasNext()){

            curr = (Integer)it.next();
            if(curr - prev == 1) {
                consec++;
                max  = Math.max(consec, max);
            }


            else{

                consec =1;
            }
            prev = curr;
        }
        return max;
    }

}
