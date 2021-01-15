package javaScript;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能问题
public class Test10 {

    //普通方式调用
    public void test01(){
        User user=new User();

        long startTime=System.currentTimeMillis();

        for(int i=0;i<1000000000;i++){
            user.getName();
        }

        long enTime=System.currentTimeMillis();
        System.out.println("普通方式执行十亿次"+(enTime-startTime));
    }
    //反射方法调用
    public void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user=new User();
        Class cl=user.getClass();

        Method getname=cl.getDeclaredMethod("getName",null);

        long startTime=System.currentTimeMillis();

        for(int i=0;i<1000000000;i++){
            getname.invoke(user,null);
        }

        long enTime=System.currentTimeMillis();
        System.out.println("反射方式执行十亿次"+(enTime-startTime));
    }

    //反射方式调用 关闭检测
    public void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user=new User();
        Class cl=user.getClass();

        Method getname=cl.getDeclaredMethod("getName",null);
        getname.setAccessible(true);

        long startTime=System.currentTimeMillis();

        for(int i=0;i<1000000000;i++){

            getname.invoke(user,null);
        }

        long enTime=System.currentTimeMillis();
        System.out.println("关闭检测执行十亿次"+(enTime-startTime));
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Test10 t=new Test10();
        t.test01();
        t.test02();
        t.test03();
    }
}
