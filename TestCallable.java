package Thread.Callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//实现多线程同步下载图片
class TestCallable implements Callable<Boolean> {
    private String url;//网络图片地址
    private String name;//保存的文件名
    public TestCallable (String url,String name){
        this.url=url;
        this.name=name;
    }
    //下载图片线程的执行体
    @Override
    public Boolean call() {
        webDownLoader web=new webDownLoader();
        web.downLoader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t=new TestCallable("https://img-home.csdnimg.cn/images/20201231031228.jpg","28.jpg");
        TestCallable t1=new TestCallable("https://img-home.csdnimg.cn/images/20210101032346.jpg","46.jpg");
        TestCallable t2=new TestCallable("https://img-home.csdnimg.cn/images/20210101031518.jpg","18.jpg");

        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> rl1=ser.submit(t);
        Future<Boolean> rl2=ser.submit(t);
        Future<Boolean> rl3=ser.submit(t);

        //获取结果
        boolean rs1=rl1.get();
        boolean rs2=rl2.get();
        boolean rs3=rl3.get();

        //关闭服务
        ser.shutdownNow();
    }


}

//下载器
class webDownLoader{
    //下载方法
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader方法出现问题");
        }
    }
}
