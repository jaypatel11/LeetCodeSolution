import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/8/13
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeToSellStock {


    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int stockPrices[];

        System.out.println("Enter length:");

        int len = in.nextInt();

        stockPrices = new int[len];

        for(int i = 0 ; i < len; i++){

            stockPrices[i] = in.nextInt();

        }

        int maxProfit = getMaxProfit1(stockPrices);
        maxProfit = getMaxProfit2(stockPrices);
        maxProfit = getMaxProfit3(stockPrices);
        System.out.println(maxProfit);
    }

    private static int getMaxProfit3(int[] prices) {

        if(prices == null || prices.length == 0 )
            return 0;

        int futureProfit[] = new int[prices.length];
        int historyProfit[] = new int[prices.length];
        int valley = prices[0];
        int maxProfit = 0;
        for( int i = 1; i < prices.length; i++){

            valley = Math.min(prices[i],valley);


            historyProfit[i] = Math.max(historyProfit[i-1], prices[i]- valley);

        }

        int peak = prices[prices.length -1];
        for(int i = prices.length - 2; i >=0 ; i--){

            peak = Math.max(peak, prices[i]);

            futureProfit[i] = Math.max(futureProfit[i+1], peak - prices[i]);

            maxProfit = Math.max(maxProfit, futureProfit[i] + historyProfit[i]);

        }


        return maxProfit;
    }

    private static int getMaxProfit2(int[] prices) {

        int buyPrice;
        if(prices == null || prices.length == 0)
            return 0;
        buyPrice = prices[0];
        int globalProfit = 0;
        for( int i = 1 ; i < prices.length; i++){

            if(buyPrice > prices[i])
                buyPrice = prices[i];
            else{

                globalProfit += prices[i]-buyPrice;
                buyPrice = prices[i];
            }
        }
        return globalProfit;

    }

    private static int getMaxProfit1(int[] prices) {

        int buyPrice;
        int sellPrice;
        if(prices == null || prices.length == 0 )
            return 0;

        buyPrice = prices[0];
        int globalProfit = 0;
        for( int i = 1 ; i < prices.length; i++){

             if( prices[i] < buyPrice){

                 buyPrice = prices[i];
             }

             if(prices[i] > buyPrice ){

                 sellPrice = prices[i];

                 if(globalProfit < sellPrice - buyPrice)
                     globalProfit = sellPrice - buyPrice;
             }
        }


        return globalProfit;
    }
}
