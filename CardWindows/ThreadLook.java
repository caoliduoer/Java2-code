package CardWindows;

public class ThreadLook {
    public static void main(String[] args) {

        //同时启动20个线程，每个线程从0到加到9999；
        for (int i=0;i<20;i++){
            Thread t=new Thread(){
                @Override
                public void run() {//多线程环境下，即使同一个代码块，也是可以并发执行的
                    for(int i=0;i<10000;i++){
                        i++;
                        if(i==9999){
                            System.out.println(i);
                        }
                    }

                }
            };
            t.start();
        }


    }

}
