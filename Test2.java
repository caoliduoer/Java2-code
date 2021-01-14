package javaScript;

//测试class类的创建方式有哪些
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person=new Student();
        System.out.println("这个人是："+person.name);
        //方式一：通过对象获得；
        Class cl=person.getClass();
        System.out.println(cl.hashCode());

        //方法二：forname获得
        Class c1=Class.forName("javaScript.Person");
        System.out.println(c1.hashCode());

        //方法三：通过类名.class获得
        Class c2=Person.class;
        System.out.println(c2.hashCode());

        //方式四：基本内置类的包装类都有一个type属性(只有内置类）
        Class c3=Integer.TYPE;
        System.out.println(c3);

    }
}

class Person{
    String name;
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}
 class  Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
 }