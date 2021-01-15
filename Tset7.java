package javaScript;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Tset7 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class cl=Class.forName("javaScript.User");
       // User user=new User();
       // cl=user.getClass();
        //获得类的名字
        System.out.println(cl.getName());//获得包名，类名
        System.out.println(cl.getSimpleName());//获得类名


        //获得类的属性
        //Field[] fields=cl.getFields();找到public属性
        Field[] fields=cl.getDeclaredFields();//找到全部的属性
        for(Field field:fields){
            System.out.println(field);
        }
        //获得指定属性的值
        Field name=cl.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("==========");
        Method[] methods=cl.getMethods();//获得本类及其父类的全部public方法
        for(Method method:methods){
            System.out.println("正常的："+method);
        }
        System.out.println("####################");
        methods=cl.getDeclaredMethods();//获得本类的所有方法
        for(Method method:methods){
            System.out.println("getDeclaredMethods"+method);
        }

        //获得指定的方法；
       Method method= cl.getMethod("getName",null);
       Method method1= cl.getMethod("setName",String.class);
        System.out.println(method);
        System.out.println(method1);

        //获得指定的构造器；
        System.out.println("---------------");
        Constructor[] constructors=cl.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }
        constructors=cl.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println("a"+constructors);
        }

        //获得指定的构造器
        String constructor=cl.getConstructor(String.class,int.class,int.class).getName();
        System.out.println(constructor);
    }
}
