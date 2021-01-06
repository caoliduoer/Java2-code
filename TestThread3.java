package Thread;

/**
 * 多个线程操作同一个对象
 * */
public class TestThread3 implements Runnable {
    private int ticketNum=10;
    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+(ticketNum--)+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread3 r=new TestThread3();

        new Thread(r,"草里多").start();
        new Thread(r,"双双").start();
        new Thread(r,"黄牛").start();
    }
}
