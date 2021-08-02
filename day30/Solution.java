package day30;

import java.util.*;



public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param input string字符串
     * @return bool布尔型
     */
    public boolean main(String input) {
        // write code here
        boolean big=false;
        boolean small=false;
        boolean num=false;
        for(int i=0;i<input.length();i++){
            if(i==0){
                if(input.charAt(i)<'A'||input.charAt(i)>'Z'){
                    return false;
                }
            }
            else if(input.charAt(i)>='0'&&input.charAt(i)<='9'){
                num=true;
            }
            else if(input.charAt(i)>='a'&&input.charAt(i)<='z'){
                small=true;

            }
           else if(input.charAt(i)>='A'&&input.charAt(i)<='Z'){
                big=true;
            }else{
                return false;
            }


        }
        if(big && small || big && num || small && num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.main("0000000000000l"));
    }
}
