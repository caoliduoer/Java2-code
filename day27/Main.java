

//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param timeSchedule string字符串ArrayList<ArrayList<>>
     * @return int整型
     */
    public int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        if(timeSchedule.size()<=1){
            return timeSchedule.size();
        }
        int count=1;
        //String[] str=new String[timeSchedule.size()];
        int[] arr1=new int[timeSchedule.size()];
        int[] arr2=new int[timeSchedule.size()];
        //boolean flag
        for(int i=0;i<timeSchedule.size();i++){
            ArrayList<String> s=timeSchedule.get(i);
            //String s1=Arrays.toString(timeSchedule.get(i));
            StringBuffer sb1=new StringBuffer();//开始时间
            StringBuffer sb2=new StringBuffer();//结束四件
            boolean flag=true;

            for(int j=0;j<s.size();j++){

                if(flag&&Integer.parseInt(s.get(j))>=0&&Integer.parseInt(s.get(j))<=9){
                    sb1.append(s.get(j));
                }
                if(!flag&&Integer.parseInt(s.get(j))>=0&&Integer.parseInt(s.get(j))<=9){
                    sb2.append(s.get(j));
                }
                flag=false;
            }
            arr1[i]= Integer.parseInt(sb1.toString());
            arr2[i]= Integer.parseInt(sb2.toString());



        }
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length-i-1;j++){
                if(arr1[j]>arr1[j+1]){
                    arr1[j]^=arr1[j+1];
                    arr1[j+1]^=arr1[j];
                    arr1[j]^=arr1[j+1];
                    arr2[j]^=arr2[j+1];
                    arr2[j+1]^=arr2[j];
                    arr2[j]^=arr2[j+1];
                }
            }
        }
        for(int i=1;i<arr1.length;i++){
            if(arr1[i]>=arr2[i-1]){
                count++;
            }
        }

        return  count;
    }
}
/*
 * [["10:00","12:00"],["03:00","11:30"],["11:30","14:00"]]*/