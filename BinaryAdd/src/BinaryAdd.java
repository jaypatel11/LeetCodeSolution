import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/7/13
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryAdd {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        String binary1;
        String binary2;

       binary1 = in.next();
       binary2 = in.next();

       String answer = addBinary(binary1, binary2);
        System.out.println(answer);

    }

    private static String addBinary(String binary1, String binary2) {

        if(binary1 == null || binary2 == null)
            return null;


        int lenDifference = Math.abs(binary1.length()-binary2.length());

        String concat="";

        while(lenDifference > 0){

            concat += "0";
            lenDifference--;
        }

        if(binary1.length() < binary2.length()){

            binary1 = concat + binary1;
        }

        if(binary2.length() < binary1.length()){

            binary2 = concat + binary2;

        }

        int index = binary1.length();
        String answer ="";
        int carry = 0;
        int bit1;
        int bit2;
        String partialAnswer;
        while(--index >= 0){

            bit1 = Integer.parseInt(binary1.charAt(index) + "");
            bit2 = Integer.parseInt(binary2.charAt(index) + "");
            partialAnswer  = addBits(bit1,bit2, carry);
            carry = Integer.parseInt((partialAnswer.charAt(0)+""));

            answer =  partialAnswer.charAt(1) + answer;
            if(index == 0 && carry ==1){

                answer = "1" + answer;
            }
        }

        return  answer;
    }

    private static String addBits(int bit1, int bit2, int carry) {

        int addition = bit1 + bit2 + carry;

        switch (addition){

            case 0:
                return "00";
            case 1:
                return "01";
            case 2:
                return "10";
            case 3:
                return "11";

            default:
                return null;
        }

    }


}
