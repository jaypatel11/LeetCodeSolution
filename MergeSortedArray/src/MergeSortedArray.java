/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/4/14
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArray {

    public static void main(String args[]){

        int B[] = {1};
        int A[] = {2,0};

        merge(A, 1, B, 1);

        for(int i = 0 ; i < A.length; i++)
            System.out.println(A[i] + " ");

    }

    public static void merge(int A[], int m, int B[], int n) {


        int i = m - 1;
        int j =n - 1;
        int k = A.length -1;
        if( A == null || B == null)
            return;

        if(A.length == B.length){

            System.arraycopy(B, 0, A, 0, B.length);
            return;
        }


        while(i >=0 && j>= 0){

            if(A[i] >= B[j]){

                A[k] = A[i];
                i--;
                k--;
            }

            else{

                A[k] = B[j];
                j--;
                k--;
            }

        }


        while(j >= 0)
            A[k--] = B[j--];

    }
}
