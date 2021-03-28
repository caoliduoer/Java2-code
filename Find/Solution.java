package Try.Find;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.Global.toObject;

public class Solution {
    public int MoreThanHalfNum_Solution1(int [] array) {
        int len=array.length/2;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])!=null){
                int a=map.get(array[i]);
                map.put(array[i],++a);
            }else{
                map.put(array[i],1);
            }
        }
        for(Integer i:map.keySet()){
            if(map.get(i)>len){
                return i;
            }
        }
        return 0;
    }
    public int MoreThanHalfNum_Solution(int [] array){
        List<Integer> list= Arrays.stream(array).boxed().collect(Collectors.toList());
        int begin=0;
        for(int i=1;i<list.size();i++){
            if (list.get(i)==list.get(begin)) {
                continue;
            }
            else{
                list.remove(i);
                list.remove(begin);
            }
            begin++;
        }
        if(list.size()>array.length/2){
            return list.get(0);
        }
        return 0;

    }

}