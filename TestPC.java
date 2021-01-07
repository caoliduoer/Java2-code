package Thread.PC;

/*
* 线程之间的通信：生产者消费者问题
*
* */
public class TestPC {
    public static void main(String[] args) {
        Data data=new Data();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//
//判断等待、业务、通知
class Data{//数字、资源类
    private int number=0;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (number!=0){
            //等待
            this.wait();
        }
        number++;
        //通知其他线程我+1完毕
        System.out.println(Thread.currentThread().getName()+"+1之后是"+number);
        this.notifyAll();
    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            //等待
            this.wait();
        }
        number--;
        //通知其他线程我-1完毕
        System.out.println(Thread.currentThread().getName()+"-1之后是"+number);
        this.notifyAll();
    }
}