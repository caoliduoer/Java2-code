package Try.FindOnlyOne;

import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        //使用类似于hash的方法存储进去
        int[] count=new int[123];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(count[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
    public int FirstNotRepeatingChar1(String str){
        HashMap<String ,Integer>map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.get(str.substring(i,i+1))==null)
                map.put(str.substring(i,i+1),1);
            else{
                int a=(map.get(str.substring(i,i+1)));
                map.put(str.substring(i,i+1),++a);
            }

        }
        String fi="";
        for(String s:map.keySet()){
            if(map.get(s)==1)
                fi=s;
            break;
        }
        if(fi.equals("")){
            return  -1;
        }
        for(int i=0;i<str.length();i++){
            if(fi.equals(str.substring(i,i+1))){
                return i;
            }
        }
        return -1;
    }
}
