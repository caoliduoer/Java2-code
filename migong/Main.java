package Try.migong;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        //接收数据
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] info1 = line1.split(" ");
        int n = Integer.parseInt(info1[0]);
        int m = Integer.parseInt(info1[1]);
        int p = Integer.parseInt(info1[2]);
        int[][] info = new int[n][m];
        //存储数据
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] l = line.split(" ");

            for (int j = 0; j < m; j++) {
                info[i][j] = Integer.parseInt(l[j]);


            }

        }
        boolean flag = true;
        Stack<Index> stack = new Stack<>();
        int i = 0;
        int j = 0;
        Index in = new Index(i, j);
        stack.push(in);
        while (!(i == 0 && j == m - 1)) {
            if (j + 1 < m && info[i][j + 1] == 1) {//向右走
                Index in1 = new Index(i, j + 1);
                stack.push(in1);
                j++;
                if ((p - 1) > 0) {
                    p--;
                } else {
                    System.out.println("Can not escape!");
                    flag = false;
                    break;
                }

            } else if (i + 1 < n && info[i + 1][j] == 1) {//向下走
                Index in3 = new Index(i + 1, j);
                stack.push(in3);
                i++;
            } else if (i - 1 >= 0 && info[i - 1][j] == 1) {//向上走
                Index in2 = new Index(i - 1, j);
                stack.push(in2);
                i--;
                if ((p - 3) > 0) {
                    p -= 3;
                } else {
                    System.out.println("Can not escape!");
                    flag = false;
                    break;
                }
            } else if (j - 1 >= 0 && info[i][j - 1] == 1) {//向zuo走。最不划算的
                Index in4 = new Index(i, j - 1);
                stack.push(in4);
                j--;
                if (p - 1 > 0) {
                    p--;
                } else {
                    System.out.println("Can not escape!");
                    flag = false;
                    break;
                }
            } else {//无路可走，就退回上一步
                Index in5 = stack.pop();
                i = in5.getCol();
                j = in5.getRun();
            }
        }
        //输出栈中的内容
        if (flag) {//可以走出迷宫
            while (!stack.isEmpty()) {
                Index in6 = stack.pop();
                System.out.print("[" + in6.getCol() + "," + in6.getRun() + "]");
                if (stack.size() != 1) {
                    System.out.print(",");
                }
            }
        }


    }

    public Index getBetter(int i, int j, int n, int m, int[][] arr) {//得到本位置的最佳路径
        double mix = 100;
        Index in1 = null;
        if (i - 1 >= 0 && arr[i][j] == 1) {//向上的路径可以走
            double temp1 = Math.sqrt(Math.pow(i - 1, 2) + Math.pow(m - 1 - j, 2));
            if (temp1 < mix) {
                in1 = new Index(i - 1, j);
                mix = temp1;
            }
        }
        if (j - 1 > 0 && arr[i][j] == 1) {//向左可以走
            double temp2 = Math.sqrt(Math.pow(i, 2) + Math.pow(m - 1 - j - 1, 2));
            if (temp2 < mix) {
                mix = temp2;
            }
        }
        if (i + 1 < n && arr[i + 1][j] == 1) {//向下可以走
            double temp3 = Math.sqrt(Math.pow(i + 1, 2) + Math.pow(m - 1 - j, 2));
            if (temp3 < mix) {
                mix = temp3;
            }
        }
        if (j + 1 < m && arr[i + 1][j] == 1) {
            double temp4 = Math.sqrt(Math.pow(i + 1, 2) + Math.pow(m - j, 2));
        }
        return in1;

    }

    static class Index {
        int col;
        int run;

        public Index(int col, int run) {
            this.col = col;
            this.run = run;
        }

        public int getCol() {
            return this.col;
        }

        public int getRun() {
            return this.run;
        }
    }
}
/**
 * 4 4 10
 * 1 0 0 1
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 1 1*/
/*
4 4 10
1 0 0 1
1 1 0 1
0 1 1 1
0 0 1 1
*/