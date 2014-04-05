import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/24/13
 * Time: 2:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class YodleTriangle {

    public static void main (String args[]) throws IOException{

        BufferedReader br =null;
        try{

            File file = new File("./triangle.txt");

            br = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
            while ((line = br.readLine()) != null) {

                String[] levelArray = line.split(" ");
                ArrayList<Integer> levelList = new ArrayList<Integer>();

                for( int i = 0; i < levelArray.length; i++){

                    levelList.add(Integer.parseInt(levelArray[i]));

                }

                input.add(levelList);


          }
          System.out.println("Max:"+ findMaxPathSum(input));
        }
        catch (FileNotFoundException  ex){

            System.out.println(ex);
        }

        finally {

            br.close();

        }


    }

    private static int findMaxPathSum(ArrayList<ArrayList<Integer>> input){


        int inputSize = input.size();
        if(inputSize  == 0)
            return 0;

        int firstLevelElement = input.get(0).get(0);

        if( inputSize == 1)
            return firstLevelElement;


        int[] tempResult = new int[inputSize];
        int[] result = new int[inputSize];
        int maxSum = Integer.MIN_VALUE;
        result[0] = firstLevelElement;

        for( int i = 1; i < inputSize; i++){

            ArrayList<Integer> currentLevelList = input.get(i);
            tempResult[0] = result[0] + currentLevelList.get(0);
            for( int j = 1; j < currentLevelList.size() -1; j++){

                tempResult[j] = Math.max(result[j] + currentLevelList.get(j), result[j-1] + currentLevelList.get(j));

            }

            tempResult[currentLevelList.size() -1] = currentLevelList.get(currentLevelList.size()-1) + result[i-1];

            System.arraycopy(tempResult, 0, result, 0, tempResult.length);
        }



        for( int i = 0; i < result.length; i++){

            maxSum = Math.max(maxSum, result[i]);
        }

        return maxSum;


    }





}
