package Try.backTrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    static ArrayList<String> list=new ArrayList<>();
    static StringBuffer path=new StringBuffer();
   // ArrayList<String> paths=new ArrayList<>();
    static TreeSet<String> paths=new TreeSet<>();
    static boolean[] station;
    public static void main(String[] args) {
        String str="aa";
        ArrayList<String> l=Permutation(str);

        for(String s:l){
            System.out.println(s);
        }
    }
    public static ArrayList<String> Permutation(String str){
        if(str.length()==0||str.equals("")){
            return list;
        }
        station=new boolean[str.length()];
        char[] strs=str.toCharArray();
        Arrays.sort(strs);
        perm(strs,0);
        list.addAll(paths);
        return  list;
    }

    private static void perm(char[] strs, int len) {
        if(strs.length==len){
            paths.add(path.toString());
            return;
        }
        for(int i=0;i< strs.length;i++){
            if(!station[i]){
                station[i]=true;
                path.append(strs[i]);
                perm(strs,len+1);
                station[i]=false;
                path.deleteCharAt(path.length()-1);
            }
        }

    }

}
