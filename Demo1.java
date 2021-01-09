package Thread;

import java.util.concurrent.*;

//使用线程池创建线程
public class Demo1 {
    //Executors 工具类:3大方法
//  方法一：  newSingleThreadExecutor()//创建单个线程
//  方法二：  newFixedThreadPool()//创建一个固定线程池的大小
//  方法三：   Executors.newCachedThreadPool()//可伸缩的线程池大小
    /*
    * 四个拒绝策略：
    * 1.ThreadPoolExecutor.AbortPolicy()//例如银行满了，还有人进来，就不处理这个人的，抛出异常
    *  2.new ThreadPoolExecutor.CallerRunsPolicy()//从哪里来的，就去哪里
    *   3.new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了,丢掉任务，不会抛出异常
    *   4. new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试和最早的竞争，如果竞争失败，就释放，如果成功就执行
     * */
    public static void main(String[] args) {
        //自定义线程池工作ThreadPoolExecutor
       // ExecutorService threadPool=Executors.newSingleThreadExecutor();//单个线程
       //ExecutorService threadPool=Executors.newFixedThreadPool(5);//创建一个固定的线程池的大小
        //ExecutorService threadPool=Executors.newCachedThreadPool();//可伸缩的，遇强则强
        System.out.println(Runtime.getRuntime().availableProcessors());//获取CPU的核数，但是不一定准确。操作系统相信硬件说的，而虚拟机又相信操作系统说的
        ExecutorService threadPool=new ThreadPoolExecutor(2,5,3,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()//例如银行满了，还有人进来，就不处理这个人的，抛出异常
                //new ThreadPoolExecutor.CallerRunsPolicy()//从哪里来的，就去哪里
                // new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试和最早的竞争，如果竞争失败，就释放，如果成功就执行
                new ThreadPoolExecutor.DiscardPolicy()//队列满了,丢掉任务，不会抛出异常
        );
        try {
            for(int i=0;i<9;i++){
                //使用线程池创建了线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ---ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdownNow();
        }
        //
        System.out.println("main ok");
    }
}
