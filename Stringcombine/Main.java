package Try.Stringcombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static List<List<String>> group(String[] strs){
        TreeMap<String ,List<String>> map=new TreeMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);

            if(!map.containsKey(String.valueOf(ch))){

                map.put(Arrays.toString(ch),new ArrayList<>());
            }
                map.get(Arrays.toString(ch)).add(s);

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] st= {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists=group(st);
        for(List l:lists){
            for(Object s:l){
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
}
