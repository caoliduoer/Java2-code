package CardWindows;

public class ThreadLook1 extends Thread{
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                for (int i=0;i<=20;i++){
                    if(i==20){//某个线程抛异常，如果抛到run方法，整个线程直接终止
                        //但是不会影响其他进程
                        //线程中，处理机场的方式：线程对象。setUncaughtExceptionHander()
                        //或者在自己的run里面捕获；
                        throw new RuntimeException();
                    }
                    System.out.println(i);
                }
            }
        };
        t.start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{
            System.out.println(9);
        },"wode").start();
    }
}
