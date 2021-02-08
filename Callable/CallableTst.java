package Thread.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTst {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();

        MyThread thread=new MyThread();
        FutureTask futureTask=new FutureTask<>(thread);//适配类

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//会被缓存，提高效率

        String s=(String)futureTask.get();//获取callable的返回结果
        //ge操作可能产生阻塞
        System.out.println(s);
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() {
        System.out.println("call()");
        return "1024";
    }
}