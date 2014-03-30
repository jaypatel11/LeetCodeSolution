import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/17/13
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntegerToRoman {


    enum Numeral{

        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
        int weight;

        Numeral(int weight) {
            this.weight = weight;
        }
    };


    public static void main(String args[]){

        System.out.println(integerToRoman(1904));
    }

    private static String integerToRoman(int num) {

        Numeral[] numericValues = Numeral.values();
        String roman = new String();

        for(int i = numericValues.length -1; i >= 0; i--){

            while(num >= numericValues[i].weight){

                roman += numericValues[i];
                num -= numericValues[i].weight;
            }
        }

        return roman;
    }


}
