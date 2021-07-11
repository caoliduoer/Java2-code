package day15;
/*
* 判断1-n的数字里出现1的次数
* */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {

        int count=1;
        if(n<1){
            return 0;
        }
        if(n<10)
            return 1;
        else{
            for(int i=10;i<=n;i++){
                String s=Integer.toString(i);
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)=='1'){
                        count++;
                    }
                }
            }
        }
        return count;

    }
}