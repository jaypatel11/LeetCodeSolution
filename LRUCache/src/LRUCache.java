import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/21/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {


    HashMap<Integer, Integer> cache ;
    //List of keys in the order of least recently used to most used
    LinkedList<Integer> frame ;
    static int size;

    public LRUCache(int capacity) {

        cache = new HashMap<Integer, Integer>(capacity);
        frame = new LinkedList<Integer>();
        size = capacity;
    }

    public int get(int key) {

        if(!cache.containsKey(key))
            return -1;

        frame.remove((Integer)key);
        frame.addLast(key);

        return cache.get(key);


    }

    public void set(int key, int value) {


        if(cache.get(key) != null){

            frame.remove(key);
        }

        else{

            if(cache.size() == size){

                int first  = frame.getFirst();
                cache.remove(first);
                frame.removeFirst();
            }
        }

        frame.addLast(key);
        cache.put(key, value);
    }

    public static void main(String args[]){


        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2,1);
        System.out.println(lruCache.get(2));
        /*HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        System.out.println(map.get(1));;*/
    }
}
