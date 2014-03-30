import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/23/13
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class PQueue {


    public static void main(String args[]){


        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(9);
        pq.add(3);
        pq.add(1);
        while(pq.size()!=0){
            System.out.println(pq.poll());
        }
    }


}
