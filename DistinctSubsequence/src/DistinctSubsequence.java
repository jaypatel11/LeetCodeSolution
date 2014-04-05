/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/11/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequence {


    public static void main( String args[]){

        int a[] = {4, 5 , 2, 1, 3};
        System.out.println(numDistinct("rabbbit", "rabbit"));

    }

    public static int numDistinct(String S, String T) {
        int[] occurence = new int[T.length() + 1];
        occurence[0] = 1;
        for(int i = 0; i < S.length(); i++){
            System.out.println("Character[i]:"+S.charAt(i));
            for(int j = T.length() - 1; j >= 0 ; j--){

                System.out.println("Character[j]:"+T.charAt(j));

                if(S.charAt(i) == T.charAt(j)){
                    if(occurence[j] > 0)
                        occurence[j + 1] += occurence[j];
                }
                for(int k = 0 ; k < occurence.length; k++)
                    System.out.print(occurence[k]+" ");

                System.out.println();
            }

        }
        return occurence[T.length()];
    }

}
