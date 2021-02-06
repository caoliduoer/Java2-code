package CardWindows;

public class CreateThread {
    public static void main(String[] args) {
        Runnable r=new Runnable() {//任务描述的可执行类：传入线程对象的构造方法
            @Override
            public void run() {//线程运行态时，执行

            }
        };
        Thread t=new Thread(r);
        t.start();
    }
}
