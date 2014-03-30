/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/7/14
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {

    private static int[] helper;
    public static void main(String args[]){

        int a[] = new int[20];
        for(int i = 0; i < a.length; i++){

            a[i] = (int)(Math.random()*100);
        }

        for( int i: a)
            System.out.print(i+" ");
        System.out.println();

        mergeSort(a);
        for( int i: a)
            System.out.print(i+ " ");
        System.out.println();

    }

    private static void mergeSort(int[] a) {

        helper = new int[a.length];
        mergeSortHelper(a, 0, a.length - 1);
    }

    private static void mergeSortHelper(int[] a, int low, int high) {

        if(low >= high)
            return;

        int mid = (low + high)/2;

        mergeSortHelper(a, low, mid);
        mergeSortHelper(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {

        int i = low;
        int j = mid +1;
        int k = low;
        for (int p = low; p <= high; p++) {
            helper[p] = a[p];
        }

        while(i <= mid && j <= high){

            if(helper[i] >= helper[j]){


                a[k++] = helper[j++];
            }
            else
                a[k++] = helper[i++];
        }

        while (i <= mid) {
            a[k] = helper[i];
            k++;
            i++;
        }
    }
}
