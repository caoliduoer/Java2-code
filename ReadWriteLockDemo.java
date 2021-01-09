package Thread.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* readwriteLock
* 独占锁（写锁）---每次只能有一个线程使用
* 共享锁（读锁）---多个线程可以同时占用
* 读*读 可以共存
* 读*写  不能共存
* 写*写  不能共存！
* */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
         MyCache myCache=new MyCache();

         //写入
        for(int i=0;i<5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
/*
* 自定义缓存
* */
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    //读写锁：更加细致的控制
    private ReadWriteLock lock=new ReentrantReadWriteLock();

        //存、写入的时候，只希望同时只有一个线程操作


    //存，写
    public void put(String key,Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    //取，读
    public void get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读入"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}