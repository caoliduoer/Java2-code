package Thread.Myvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class Vdemo {
    //volatile不保证原子性
    //使用AtomicInteger保证原子性
    private static AtomicInteger num=new AtomicInteger();
    public static void add(){num.getAndIncrement();}

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while(Thread.activeCount()>2){//两个线程是一直在的，main线程和gc线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
