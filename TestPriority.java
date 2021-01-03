package Thread;

//测试线程的优先级
public class TestPriority extends Thread{
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();

        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);
        Thread t7=new Thread(myPriority);


        //先是指优先级，再启动
        t1.start();
        t2.setPriority(2);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(8);
        t4.start();

        /*t5.setPriority(-1);
        t5.start();
        t6.setPriority(11);
        t6.start();*/
        t7.setPriority(9);
        t7.start();
    }
}

class  MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}