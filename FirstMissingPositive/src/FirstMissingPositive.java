/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/13/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class FirstMissingPositive {


    public static void main(String args[]){


        int numbers[] = {0,1,2};

        System.out.println(findFirstMissingPositive(numbers));
    }

    private static int findFirstMissingPositive(int[] numbers) {

        for(int i  = 0; i < numbers.length; i++){



            while(numbers[i] != i+1){

                if(numbers[i] <=0 || numbers[i] > numbers.length || numbers[i] == numbers[numbers[i]-1])
                    break;


                    int temp = numbers[i];
                    numbers[i] = numbers[temp -1];
                    numbers[temp -1] = temp;


            }
        }

        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] != i+1)
                return i+1;

        return numbers.length+1;


    }
}
