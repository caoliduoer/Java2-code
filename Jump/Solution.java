package Jump;

public class Solution {
    public int JumpFloor(int target) {
        if(target==0){
            return 1;
        }if(target==2||target==1){
            return target;
        }

        int a=1;
        int b=2;
        int c=0;
        for(int i=3;i<=target;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
