/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/14/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class MagicArray {


    public static void main (String args[]){

        int array[] ={-10, -5, 1, 2, 2, 3, 4,7, 9, 12, 13};

        System.out.println(findMagicIndex(array));

    }


    private static int findMagicIndex(int array[]){


        int index = findMagicIndexDuplicateHelper(array, 0, array.length - 1);
        return index;

    }

    private static int findMagicIndexHelper(int[] array, int low, int high) {

        if(low > high || array.length == 0 || low < 0 || high > array.length -1)
            return -1;

        int mid = (low + high)/2;

        if(array[mid] == mid)
            return mid;

        else if(array[mid] > mid)
            return findMagicIndexHelper(array, low, mid -1);

        else
            return findMagicIndexHelper(array, mid+1, high);
    }

    private static int findMagicIndexDuplicateHelper(int[] array, int low, int high) {

        if(low > high || array.length == 0 || low < 0 || high > array.length -1)
            return -1;

        int midIndex = (low + high)/2;

        if(array[midIndex] == midIndex)
            return midIndex;


        int leftIndex = Math.min(midIndex - 1, array[midIndex]);
        int left =  findMagicIndexDuplicateHelper(array, low, leftIndex);
        if(left >= 0)
            return left;

        int rightIndex = Math.max(midIndex + 1, array[midIndex]);
        int right =  findMagicIndexDuplicateHelper(array, rightIndex, high);

        return right;



    }
}