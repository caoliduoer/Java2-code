package Thread;


/**
* 实现阻塞队列：put、take不具有原子性
 *put操作，如果满了，需要阻塞等待，take如果是空，需要阻塞等待。
* */
public class MyBlockingQueue<T> {
    private Object[] queue;

    //存放元素的索引
    private int putIndex;

    //取元素的索引
    private int takeIndex;

    //当前存放元素的数量
    private  int size;

    public MyBlockingQueue(int len){
        queue=new Object[len];
    }

    //存放元素：1要考虑putIndex》数组长度；2.size达到数组最大长度
    public synchronized void  put(T e) throws InterruptedException {
        //当阻塞等待到被唤醒并再次竞争成功对象锁，恢复后往下执行时，条件可能会被其他线程修改了
        while (size==queue.length){
            this.wait();
        }
        queue[putIndex]=e;//存放到数组中放元素的位置
        //存放位置超过数组长度
        putIndex=(putIndex+1)%queue.length;
        size++;
        notifyAll();//this.notifyAll();---->和synchronized加锁的对象一致
    }

    //取元素
    public synchronized T take() throws InterruptedException {
        while (size==0){
           wait();
        }
        T t=(T)queue[takeIndex];
        queue[takeIndex]=null;
        takeIndex=(takeIndex+1)%queue.length;

        size--;
        notifyAll();
        return t;
    }

    public synchronized int size(){
        return size;
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<String> queue=new MyBlockingQueue<String>(10);
        for (int i = 0; i < 10; i++) {
            queue.put(String.valueOf(i));
        }
        queue.take();
        queue.put("10");
        for(Object s:queue.queue){
            System.out.println(s);
        }
    }
}
