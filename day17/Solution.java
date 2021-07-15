package day17;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int[] arr=new int[123];//z的ASCII码为122
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(arr[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}