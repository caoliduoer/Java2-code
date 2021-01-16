package same;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int height=sc.nextInt();
        int[][] one=new int[height][length];
        int[][] two=new int[height][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<height;j++){
                one[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<length;i++){
            for(int j=0;j<height;j++){
                two[i][j]=sc.nextInt();
            }
        }
        int count=0;
        for(int i=0;i<length;i++){
            for(int j=0;j<height;j++){
                if(one[i][j]==two[i][j]){
                    count++;
                }
            }
        }
        float same=(float)count/(height*length);
        System.out.printf("%.2f",same);
    }
}