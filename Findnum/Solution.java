package Findnum;

public class Solution {
    public static boolean Find(int target, int [][] array) {
        int i=0;
        int j=array.length-1;
        while(i<array[0].length&&j>=0){
            if(target>array[j][i]){
                i++;
            }else if(target==array[j][i]){
                return true;
            }
            else{
                j--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3},{4,5,6}};
        Find(3,arr);
    }
}