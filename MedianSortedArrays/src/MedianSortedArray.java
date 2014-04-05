/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/3/14
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MedianSortedArray {

    public static void main(String args[]){


        double array1[] = {2,3,6,7};
        double array2[] = {2.5, 3.5,4 ,5,6};
        System.out.println(findMedian(0, array1.length -1,array1, 0, array2.length-1, array2));
    }

    private static double min(double a, double b, double c){

        return Math.min(Math.min(a,b),c);
    }


    private static double findMedian(int start1, int end1, double[] array1, int start2, int end2, double[] array2) {

        if000ray1 == null || array2 == null)
            return 0;

        int arrayLength1 = end1- start1 ;
        int arrayLength2 = end2- start2;

        if(arrayLength1 + arrayLength2 + 2== 2){

            return (array1[start1]+array2[start2])/2.0;
        }

        if(arrayLength1 + arrayLength2 + 2== 3){

            return arrayLength1>arrayLength2? min(array1[start1], array1[end1], array2[start2]):min(array2[start2], array2[end2], array1[start1]);
        }
        if(arrayLength1 + arrayLength2 +2== 4){

            return (Math.max(array1[start1], array2[start2]) + Math.min(array1[end1], array2[end2]))/2.0;
        }

        int medianIndex1 = arrayLength1/2 ;
        int medianIndex2 = arrayLength2/2 ;

        double median1 = arrayLength1 %2== 0? (array1[medianIndex1]+array1[medianIndex1 ])/2.0 : array1[medianIndex1];
        double median2 = arrayLength2 %2 == 0? (array2[medianIndex2]+array2[medianIndex2 ])/2.0 : array2[medianIndex2];

        if( median1 >= median2){

           return findMedian(start1, medianIndex1, array1, medianIndex2, end2, array2);

        }
        else
            return findMedian(medianIndex1, end1, array1, start2, medianIndex2, array2);



    }
}
