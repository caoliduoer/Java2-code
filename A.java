package javaScript;

/*
* 1.加载到内存里，会产生一个类对应class对象
*
* */
public class A {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(Test.n);
    }


}

class Test{
    static {
        System.out.println("A类静态代码块初始化");
    }
    static int n=100;

    public Test(){
        System.out.println("A的无参构造初始化");
    }
}