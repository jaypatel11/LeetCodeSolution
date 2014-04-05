import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/5/14
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */

public class MinPathSum {

    static Map<List<Integer>, Integer> minPathHashMap = new HashMap<List<Integer>, Integer>();
    public static void main(String args[]){

        int grid[][] ={{3,0,1,2},
                {5,9,3,4},
                {4,8,7,6},
                {8,9,9,4}};
        System.out.println(findMinPathSum(grid));

    }

    public static int findMinPathSum(int grid[][]){

            if(grid == null )
                return 0;
            minPathHashMap.clear();
            return findMinPathSumHelper(0, 0, grid);
    }

    private static int findMinPathSumHelper(int i, int j, int[][] grid) {


        List<Integer> key = new ArrayList<Integer>();
        key.add(i);
        key.add(j);
        if(minPathHashMap.containsKey(key))
            return minPathHashMap.get(key);


        int currSum = grid[i][j];
        if(i == grid.length -1 && j == grid[0].length -1) {

            currSum += 0;

        }



        else if(i == grid.length -1){

            currSum += findMinPathSumHelper(i, j +1, grid) ;
        }


        else if(j == grid[0].length -1){

            currSum +=  findMinPathSumHelper(i +1, j, grid);
        }

        else {

                currSum += Math.min(findMinPathSumHelper(i+1, j, grid), findMinPathSumHelper(i, j+1, grid));
        }


        minPathHashMap.put(key, currSum);

        return currSum;

    }
}
