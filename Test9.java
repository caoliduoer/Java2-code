package javaScript;


//动态创建对象，通过反射

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test9 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
       //获得class对象
        Class  cl=Class.forName("javaScript.User");

        //构建一个对象
//        User u=(User) cl.newInstance();//本质上是调用了无参构造器
//        System.out.println(u);

        //构造器创建对象
        /*Constructor c=cl.getDeclaredConstructor(String.class,int.class,int.class);
        User user=(User) c.newInstance("多多",11,18);
        System.out.println(user);*/

        //通过反射调用普通方法
        User user =(User)cl.newInstance();
        //通过反射获取一个方法

        Method setName=cl.getDeclaredMethod("setName", String.class);
        //invoke：激活的意思
        //参数(对象，对象的值）

        setName.invoke(user,"duoduo");
        System.out.println(user.getName());

        //通过反射操作属性
        User user1=(User)cl.newInstance();
        Field name=cl.getDeclaredField("name");

        //不能直接操作私有属性，我们需要关闭程序的安全监测，属性或者方法setAccessible(true)才可
        name.setAccessible(true);
        name.set(user1,"caoliduoer");
        System.out.println(user1.getName());

    }
}
