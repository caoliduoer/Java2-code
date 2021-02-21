package cover;

public class Solution {
    public int rectCover(int target) {
        if(target==0||target==1){
            return target;
        }
        int a=1;//a、b的值要根据实际情况来设定
        int b=1;
        int c=0;
        for(int i=2;i<=target;i++){
            c=a+b;
            a=b;
            b=c;
        }


        return c;
    }

    public static void main(String[] args) {
        
    }
}
