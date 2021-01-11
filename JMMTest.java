package Thread.Myvolatile;

import java.util.concurrent.TimeUnit;

public class JMMTest {
    private volatile static  int num=0;//如果程序不加volatile就会死循环，结论volatile可以保证可见性
    public static void main(String[] args) {//main
        new Thread(()->{//线程1  对主存的值改变时不知道的
            while ((num == 0)) {
            }
            System.out.println("变了");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num=1;

        System.out.println(num);
    }
}
