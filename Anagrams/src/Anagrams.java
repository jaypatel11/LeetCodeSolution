import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/8/13
 * Time: 2:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Anagrams {


    public static void main(String args[]){

         String str[] = {"tea", "bag","eat","ate","gab"};

        System.out.println(anagrams(str));

    }

    public static ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<String, ArrayList<String>> possibleAnagramsMap;

        if(strs == null)
            return null;

        possibleAnagramsMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> stringArrayList;
        String inputKey;
        for(int i = 0 ; i < strs.length; i++){

            char[] inputStringArray = strs[i].toCharArray();
            Arrays.sort(inputStringArray);
            inputKey = new String(inputStringArray);
            if(!possibleAnagramsMap.containsKey(new String(inputStringArray))){

                   stringArrayList = new ArrayList<String>();
                   stringArrayList.add(strs[i]);

                   possibleAnagramsMap.put(inputKey, stringArrayList);

            }
             else{

                stringArrayList = (ArrayList)possibleAnagramsMap.get(inputKey);
                stringArrayList.add(strs[i]);

            }

        }
        ArrayList<String> anagrams = new ArrayList<String>();
        Iterator it = possibleAnagramsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            ArrayList<String> mapStringList = (ArrayList)pairs.getValue();

            if(mapStringList.size() > 1){


                anagrams.addAll(mapStringList);


            }
        }



      return anagrams;

    }
}
