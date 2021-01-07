package Thread.PC;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 线程之间的通信：生产者消费者问题
*
* */
public class TestPC1 {
    public static void main(String[] args) {
        Data data=new Data();



    }
}

//
//判断等待、业务、通知
class Data1{//数字、资源类
    private int number=0;

    Lock lock=new ReentrantLock();
    Condition connection = lock.newCondition();

    //+1
    public  void increment() throws InterruptedException {

            lock.lock();
            try {
                while (number!=0){
                    //等待
                    connection.await();
                }
                number++;
                //通知其他线程我+1完毕
                System.out.println(Thread.currentThread().getName()+"+1之后是"+number);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


    }
    //-1
    public  void decrement() throws InterruptedException {
        lock.lock();
        while (number==0){
            //等待
            connection.await();
        }
        number--;
        //通知其他线程我-1完毕
        System.out.println(Thread.currentThread().getName()+"-1之后是"+number);
        lock.unlock();
    }
}