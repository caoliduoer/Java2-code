package CardWindows;

public class Mythround extends Thread{
    public static void main(String[] args) {
        //main 线程中“new线程对象，匿名内部类thread子类重写run方法
        Thread t=new Thread(){
            @Override
            public void run() {//线程进入运行状态之后执行
                while(true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //
        t.start();
        while (true){

        }
    }
}
