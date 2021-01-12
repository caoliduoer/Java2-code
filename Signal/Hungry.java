package Thread.Signal;

//饿汉模式
public class Hungry {
    private byte[] data1=new byte[1024*1024];
    private byte[] data2=new byte[1024*1024];
    private byte[] data3=new byte[1024*1024];
    private byte[] data4=new byte[1024*1024];

    private Hungry(){

    }
    private final static Hungry HUNGRY=new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Hungry hungry=new Hungry();
        hungry.clone();
    }
}
