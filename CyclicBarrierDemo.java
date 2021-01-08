package Thread.ThreeClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /*
        * 集齐七颗龙珠召唤神龙
        * 召唤龙珠的线程
        * */
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->
        {
            System.out.println("召唤神龙成功！");
        });
        for (int i = 0; i <7 ; i++) {
            int finalI = i;
            //lambda操作不到i;
            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"收集"+finalI+"个龙珠");
                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
