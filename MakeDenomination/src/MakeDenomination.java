/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/15/13
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class MakeDenomination {

    public static void main(String args[]){


        System.out.println(makeDenomination(10));


    }

    private static int makeDenomination(int n) {

        return makeDenominationHelper(n, 25);
    }

    private static int makeDenominationHelper(int n, int denom) {

        int nextDenom = 0;

        switch(denom){


            case 25:
                nextDenom = 10;
                break;

            case 10:
                nextDenom = 5;
                break;


            case 5:
                nextDenom = 1;
                break;

            case 1:
                return 1;
        }

        int ways = 0;

        for(int i = 0; i*denom <=n; i++){

            System.out.println("i:  " +i +"    Ways:" +ways + "    Denom:"+denom);
            ways += makeDenominationHelper(n-i*denom, nextDenom);

        }
        return ways;
    }

}
