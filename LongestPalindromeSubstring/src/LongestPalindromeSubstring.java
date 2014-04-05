/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/20/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindromeSubstring {


    public static void main(String args[]){


        String s = "abracadabra";

        System.out.println(findLongestPalindromeSubstring(s));
    }

    private static String findLongestPalindromeSubstring(String input) {

        // The idea is to take each character, make it the center and expand in left and right direction. There will be odd and even length expansion for each character
        int longestPalStart = 0;
        int longestPalEnd = 0;

        int left = 0;
        int right = 0;


        for( int mid = 0; mid < input.length(); mid++){

            //Odd length expansion
            left = right = mid;

            while(left>= 0 && right < input.length()){

                if(input.charAt(left) == input.charAt(right)){

                    if(right- left > longestPalEnd - longestPalStart){

                        longestPalStart = left;
                        longestPalEnd = right;

                    }


                }

                else break;

                left --;
                right++;

            }

            left = mid;
            right = mid +1;
            while(left>= 0 && right < input.length()){

                if(input.charAt(left) == input.charAt(right)){

                    if(right- left > longestPalEnd - longestPalStart){

                        longestPalStart = left;
                        longestPalEnd = right;

                    }


                }

                else break;

                left--;
                right++;
            }
        }

        return input.substring(longestPalStart, longestPalEnd+1);
    }
}
