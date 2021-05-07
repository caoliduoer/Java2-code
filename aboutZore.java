package practice;

public class aboutZore {
    public static void main(String[] args) {

        int a=trailingZeroes(5);
        System.out.println(a);
    }
    public static int trailingZeroes(int n) {
        int ans = 0;
        while(n > 0){
            n /= 5;
            ans +=n;
        }
        return ans;
    }


}
