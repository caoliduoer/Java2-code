package Thread.Signal;


import java.lang.reflect.Constructor;

//懒汉式单例
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private static volatile LazyMan lazyMan;

    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();//不是原子性操作
                    /*
                    * 1、分配内存空间
                    * 2、执行构造方法、初始化对象
                    * 3、把这个对象指向这个空间
                    * 这三个步骤是可指令重排的
                    * 为了防止这个操作进行指令重排，那么这个对象就需要volatile修饰
                    * */
                }
            }
        }
        return  lazyMan;
    }

    //多线程开发
    public static void main(String[] args) {
        LazyMan instance=LazyMan.getInstance();
        Constructor<LazyMan> constructor;
    }
}

