package Thread;

//模拟龟兔赛跑
public class Race implements Runnable{
    private static String winner;//胜利者
    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            //判断比赛是否结束
            boolean flag=gameOver(i);
            if(flag){
                break;
            }
                System.out.println(Thread.currentThread().getName()+"--->跑了"+i+"步");

        }
    }
    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if(winner==null){

            if(steps>=10){
                winner=Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Race race=new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
       // new Thread(race,"").start();

    }
}
