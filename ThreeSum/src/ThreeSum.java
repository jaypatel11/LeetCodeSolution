import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/7/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {


    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length:");
        int length = in.nextInt();

        int a[] = new int[length];

        System.out.println("Enter elements");

        for(int i = 0; i < length; i++){

            a[i] = in.nextInt();
        }




        System.out.println(threeSum(a));

    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] input) {

        Arrays.sort(input);
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempAnswer = null;
        Set<ArrayList<Integer>> allSets = new HashSet<ArrayList<Integer>>();
        int j,w, i =0;
        while( i < input.length-2){



            j = i+1;
            w = input.length-1;
            while(j < w){

                    if(input[i] +input[j]+input[w] > 0){

                         w--;
                    }

                    else if(input[i] +input[j]+input[w] < 0){

                        j++;
                    }

                    else{

                        tempAnswer = new ArrayList<Integer>();
                        tempAnswer.add(input[i]);
                        tempAnswer.add(input[j]);
                        tempAnswer.add(input[w]);
                        allSets.add(tempAnswer);
                        j++;
                    }


            }

            i++;


        }
        answer.addAll(allSets);
        return answer;
    }
}
