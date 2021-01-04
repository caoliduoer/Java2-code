package Thread;

import java.awt.*;

//死锁：多个线程互相抢着对方需要的资源，然后形成僵持
public class TestLock {
    public static void main(String[] args) {
        MakeUp g1=new MakeUp(0,"灰姑娘");
        MakeUp g2=new MakeUp(1,"白雪公主");

        g1.start();
        g2.start();
    }
}
//口红
class Lipstick{

}

//镜子
class Mirror{

}

class MakeUp extends Thread{

    //需要的资源只有一份，用static来保证只存在一份；
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;//选择
    String girlName;//用化妆品的人

    MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice==0) {
            synchronized (lipstick) {//获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror) {//一秒后获得镜子
                    System.out.println(this.girlName + "获得镜子的锁");
                }

            }
        }
            else{
                synchronized (mirror){//一秒后获得镜子
                     System.out.println(this.girlName+"获得镜子的锁");
                    Thread.sleep(2000);
                    synchronized (lipstick){//获得口红的锁
                        System.out.println(this.girlName+"获得口红的锁");
                    }
                    }


        }
    }
}