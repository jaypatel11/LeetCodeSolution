/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/17/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringInterleave {

    public static void main(String args[]){

       System.out.println(isInterleaveDP("aabcc","dbbca","aadbbcbcac"));
      /* System.out.println(isInterleaveDP("","",""));
      */
/*
        System.out.println(isInterleaveDP("a","","c"));
*/
/*
        System.out.println(isInterleaveDP("","b","b"));
*/

    }

    private static boolean isInterleave(String s1, String s2, String s3) {


        if(s1 == null && s2 == null && s3 == null)
            return true;

        if(!(s1.length() + s2.length() == s3.length()))
            return false;

        if(s1.length() == 0 && s2.length() ==0 && s3.length() == 0)
            return true;


        if(s1.length()> 0 && s2.length() > 0 && s1.charAt(0) == s2.charAt(0)){

            return isInterleave(s1.substring(1), s2, s3.substring(1)) ||  isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        if(s1.length()> 0 && s1.charAt(0) == s3.charAt(0)){

            return isInterleave(s1.substring(1), s2, s3.substring(1));
        }


        if(s2.length()> 0 && s2.charAt(0) == s3.charAt(0)){

            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        else return false;
    }


    private static boolean isInterleaveDP(String s1, String s2, String s3) {

        if(s1 == null && s2 == null && s3 == null)
            return true;

        if(s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] IL = new boolean[s1.length() + 1][s2.length()+1];


        IL[0][0] = true;

        for(int i = 1; i <= s1.length(); i++){

            if(s1.charAt(i-1) == s3.charAt(i-1))
                IL[i][0]  = IL[i-1][0];

        }


        for(int j = 1; j <= s2.length(); j++){

            if(s2.charAt(j-1) == s3.charAt(j-1))
                IL[0][j]  = IL[0][j-1];

        }


        for(int i = 1; i <= s1.length(); i++){

            for(int j = 1 ; j <= s2.length(); j++){

                if(s1.charAt(i-1) == s3.charAt(i+j-1) && s1.charAt(i-1) != s2.charAt(j-1)){

                    IL[i][j] = IL[i-1][j];
                }

                else if(s2.charAt(j-1) == s3.charAt(i+j-1) && s1.charAt(i-1) != s2.charAt(j-1)){

                    IL[i][j] = IL[i][j-1];
                }

                else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s1.charAt(i-1) == s2.charAt(j-1)){


                    IL[i][j] = IL[i-1][j] || IL[i][j-1];
                }

                else IL[i][j] = false;
            }

        }

        for(int i = 0; i < IL.length; i++){


            for(int j = 0; j < IL[0].length; j++){

                System.out.print(IL[i][j]+" ");

            }
            System.out.println();
        }
        return IL[s1.length()][s2.length()];

    }

}
