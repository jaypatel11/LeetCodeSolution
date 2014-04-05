import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/4/14
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString(){

        return "["+start + "," + end + "]";
    }

}


public class MergeIntervals {



    public static void main(String args[]){

        /*[1,2],[3,5],[6,7],[8,10],[12,16]*/
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(0,16));

        System.out.println(mergeInterval(intervals));

    }

    private static ArrayList<Interval> mergeInterval(ArrayList<Interval> intervals) {

        if( intervals == null || intervals.size() == 0 || intervals.size() ==1)
            return intervals;

        Stack<Interval> stack = new Stack();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }


        });
        stack.push(intervals.get(0));

        for(int i= 1; i < intervals.size(); i++){

            Interval currInterval = intervals.get(i);
            if( stack.peek().end >= currInterval.start){

                stack.peek().end = Math.max(stack.peek().end, currInterval.end);

            }
            else stack.push(currInterval);

        }

        ArrayList<Interval> newIntervals = new ArrayList<Interval>(stack);
        return newIntervals;

    }

}
