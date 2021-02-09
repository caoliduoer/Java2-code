package twoNumber;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println(countNum2(num));
    }

    private static int countNum2(int num) {
        int count=0;
        int factor=1;
        int low=0;
        int current=0;
        int high=0;
        while(num/factor!=0){
            low=num-(num/factor)*factor;
            current=(num/factor)%10;
            high=num/(factor*10);

            switch (current){
                case 0:
                case 1:
                    count+=high*factor;
                    break;
                case 2:
                    count+=high*factor+low+1;
                    break;
                default:
                    count+=(high+1)*factor;
                    break;
            }
            factor*=10;

        }
        return count;
    }
}