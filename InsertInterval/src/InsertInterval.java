import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/17/13
 * Time: 4:25 PM
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
public class InsertInterval {


    public static void main(String args[]){

        /*[1,2],[3,5],[6,7],[8,10],[12,16]*/
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        System.out.println(mergeInterval(intervals, new Interval(0,-1)));

    }

    private static ArrayList<Interval> mergeInterval(ArrayList<Interval> intervals, Interval newInterval) {


        int insertionIndex = -1;
        int mergeIndex = 0;
        ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();

        if(intervals == null)
            return null;

        if(intervals.size() == 0){

            mergedIntervals.add(newInterval);
            return mergedIntervals;

        }


        if(newInterval.start < intervals.get(0).start){

            insertionIndex = -1;

        }

        else{

            for(int i = 0; i < intervals.size(); i++){

                Interval currentInterval = intervals.get(i);
                if(newInterval.start > currentInterval.start && newInterval.start < currentInterval.end){

                    insertionIndex = i;
                    newInterval.start = currentInterval.start;
                    break;
                }

                else{

                    mergedIntervals.add(currentInterval);
                }
            }

        }


       /* if(insertionIndex < 0){

            return intervals;
        }*/

        for(int i = insertionIndex; i < intervals.size() -1; i++){

            Interval nextInterval = intervals.get(i+1);
            if( newInterval.end  - nextInterval.start ==1){

                mergeIndex++;
                newInterval.end = nextInterval.end;
            }

            else break;
        }

        /*newInterval.end = Math.max(newInterval.end, intervals.get(insertionIndex+mergeIndex).end);
        */
        mergedIntervals.add(newInterval);

        for(int i = insertionIndex + mergeIndex +1; i < intervals.size(); i++){


            mergedIntervals.add(intervals.get(i));
        }
        return mergedIntervals;
    }
}
