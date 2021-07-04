package day10;

import java.util.ArrayList;
import java.util.*;
public class Solution {
    public TreeSet<String> result;
    public ArrayList<String> Permutation(String str) {
        if(str==null||str.length()<=0){
            return new ArrayList();
        }
        List<Character> chars=new ArrayList<>();
        result= new TreeSet<>();
        for(char c:str.toCharArray()){
            chars.add(c);
        }
        Compose(chars,new StringBuffer(),str.length(),0);
        return new ArrayList(result);
    }
    public void Compose(List<Character> arr,StringBuffer buffer,int len,int index){
        if(index==len){
            result.add(buffer.toString());
            return;
        }
        for(int i=0;i<arr.size();i++){
            char c=arr.get(i);
            buffer.append(c);
            arr.remove(i);
            Compose(arr,buffer,len,index+1);
            arr.add(i,c);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }
}
