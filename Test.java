package Thread.Bq;

import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Test t=new Test();
        t.test3();
    }
    /*
    * 抛出异常
    * */
    public void Test(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("d"));
        //java.lang.IllegalStateException: Queue full抛出异常
        System.out.println("----------------");


        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException抛出异常

    }
    public  static  void Test1(){
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
       // System.out.println(blockingQueue.offer("d"));//false，不抛异常
        System.out.println("-------------");
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//null,不抛异常
      //  System.out.println(blockingQueue.element());会抛出异常
        System.out.println(blockingQueue.peek());
    }
    /*
    * 等待，阻塞（一直等待）
    * */
    public static  void test2() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("B");
        blockingQueue.put("C");
        //blockingQueue.put("d");//队列没有位置了，他就会一直阻塞在这个语句处
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
      //  System.out.println(blockingQueue.take());//没有元素，他就会一直阻塞到这里，等待取出。并且没有异常抛出

    }
    /*
    * 等待，阻塞（等待超时)
    * */
    public static void test3() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //blockingQueue.offer("d",2, TimeUnit.SECONDS);//等待超过两秒就退出

        System.out.println("-----------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }
}

