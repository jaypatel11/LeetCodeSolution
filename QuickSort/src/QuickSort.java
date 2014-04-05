/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/8/14
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {


    public static void main(String args[]){

        int a[] = new int[20];
        for(int i = 0; i < a.length; i++){

            a[i] = (int)(Math.random()*100);
        }

        for( int i: a)
            System.out.print(i+" ");
        System.out.println();

        quickSort(a);
        for( int i: a)
            System.out.print(i+ " ");
        System.out.println();

    }

    private static void quickSort(int[] a) {

        quickSortHelper(a, 0, a.length - 1);
    }

    public static  void swap(int[] a, int i, int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
    private static void quickSortHelper(int[] a, int low, int high) {

        if( low < high)
            return;

        int mid = (low + high)/2;

        int pivot = a[mid];

        int i = low;
        int j = high;

        while(i <= j){

            while(a[i] < pivot){

                 i++;
            }

            while(a[j] > pivot ){
                j--;
            }

            if(i <=j ){

                swap(a, i ,j);
                i++;
                j--;
            }


        }


        if(low < j)
            quickSortHelper(a, low, j);

        if(i < high)
        quickSortHelper(a, i, high);


    }
}
