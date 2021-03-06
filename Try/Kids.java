package Try;

public class Kids extends Parents{
    /**
    * 子类继承父类，他的构造方法也需要继承，所以在子类构造方法的第一行默认先调用父类的构造方法
    * */
    Kids(int a) {

        //super(a);
        System.out.println("我是孩子");
    }
    Kids(){
        this(1);
       // super(1);
        System.out.println("我是孩子");

    }

    public static void main(String[] args) {
        Kids k=new Kids(1);
        Parents p=new Parents();
        //Kids k1= (Kids) new Parents(2);
        Parents p1=new Kids(2);//等号后边是调用谁的构造方法
        p1.add();//是Parent类
    }
}
