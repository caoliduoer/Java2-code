package Thread;

//不安全的买票
//线程不安全
public class Syn {
    public static void main(String[] args) {
        BuyTicket syn=new BuyTicket();
        new Thread(syn,"caoliduo").start();
        new Thread(syn,"shuangshuang").start();
        new Thread(syn,"黄牛").start();
    }
}
class  BuyTicket implements Runnable{


    //票
    private int ticketNum=10;
    boolean flag=true;//外部停止的方式
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //买票
    }
    private void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNum<=0){
            flag=false;
            return;
        }
        //模拟延时
        Thread.sleep(100);


        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNum--);
    }
}
