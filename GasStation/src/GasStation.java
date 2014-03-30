/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/13/13
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class GasStation {

    public static void main(String args[]){

        int gas[] = {5,4,3,2,1};

        int cost[] = {4,3,2,1,1};


        System.out.println(canCompleteCircuit(gas, cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {


        int left = 0;
        int startPoint = 0;
        int required = 0;
        for(int i = 0; i < gas.length; i++){

            if(left + gas[i] < cost[i]){

                startPoint = i+1;
                required += cost[i] - left - gas[i];
                left = 0;
            }
            else{

                left += gas[i] - cost[i];
            }

        }

        if(required > left)
            return -1;

        return startPoint;
    }
}
