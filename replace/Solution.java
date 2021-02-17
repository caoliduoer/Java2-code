package replace;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        String s="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                s=s+str.charAt(i);
            }else{
                s=s+"%20";
            }
        }
        return s;
    }
    public String replaceSpace1(StringBuffer str){
        return str.toString().replace(" ","%20");
    }

    public static void main(String[] args) {
        
    }
}
