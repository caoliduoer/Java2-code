package Thread.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* A执行完唤醒B，B执行完唤醒c,c执行完之后唤醒A
* */
public class C {
    public static void main(String[] args) {
        Data2 data=new Data2();
        new Thread(data::printA,"A").start();
        new Thread(data::printB,"B").start();
        new Thread(data::printC,"C").start();
    }
}
class Data2{
    private int num=0;
    private Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    public void printA(){
        lock.lock();
            try {
                while(num!=0){
                    condition1.await();
                    //等待
            }
                //唤醒2
                num=1;
                System.out.println(Thread.currentThread().getName()+"---->AAAA");
                condition2.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

    }
    public void printB(){
        lock.lock();
        try {
            while(num!=1){
                condition2.await();
                //等待
            }
            //唤醒2
            num=2;
            System.out.println(Thread.currentThread().getName()+"---->BBBBBB");

            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
    public void printC(){
        lock.lock();
        try {
            while(num!=2){
                condition3.await();
                //等待
            }
            //唤醒2
            num=0;
            System.out.println(Thread.currentThread().getName()+"---->CCCCC");
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
