/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/19/13
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestCommonPrefix {


    public static void main(String args[]){

        String str[] = {};
        System.out.println(findLongestCommonPrefix(str));
    }

    private static String findLongestCommonPrefix(String[] str) {

        if(str == null)
            return null;

        if(str.length == 0)
            return  "";


        String firstString = str[0];
        String longestPrefix = "";
        int prefixLen = 0;
        boolean characterMatch = true;

        for( int i =0; i < firstString.length(); i++){

            characterMatch = true;

            for( int j = 1; j < str.length; j++){

                String curString = str[j];


                if(curString.length() <= prefixLen ||firstString.charAt(i) != curString.charAt(prefixLen)){

                    characterMatch = false;
                    break;
                }


            }

            if(characterMatch){

                prefixLen++;

            }

            else break;
        }

        longestPrefix = firstString.substring(0, prefixLen);

        return longestPrefix;
    }

}
