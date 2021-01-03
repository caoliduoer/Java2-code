package Thread;

public class Stop implements Runnable{
    /*
    * 测试stop：
    * 1.建议线程正常停止，利用次数，不建议死循环
    * 2.建议使用标志位---》设置一个标志位
    * 3.不要使用stop或者destroy等过时的或者JDK不建议使用的方法
    *
    * */
    //设置一个标志位
    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run......Thread"+i++);
        }

    }
    public void stop(){
        this.flag=false;
    }
    public static void main(String[] args) {
        Stop stop=new Stop();
        new Thread(stop).start();

        for(int i=0;i<1000;i++){
            System.out.println("main"+i);
            if(i==900){
                //调用stop方法切换标志位，让线程停止。
                stop.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
