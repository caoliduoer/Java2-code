package javaScript;


import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class cl=Class.forName("javaScript.Student2");

        //通过反射获得注解
        Annotation[] annotations=cl.getAnnotations();
        for(Annotation annotation:annotations){
            System.out.println(annotation);
        }
        //获得注解的value的值
        Tableduo tableduo=(Tableduo)cl.getAnnotation(Tableduo.class);
        String value=tableduo.value();
        System.out.println(value);

        //获得类指定的注解
        Field field=cl.getDeclaredField("name");
        FieldDuo annotation=field.getAnnotation(FieldDuo.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}
@Tableduo("student")
class Student2{

    @FieldDuo(columnName = "id",type = "int",length = 10)
    private int id;
    @FieldDuo(columnName = "age",type = "int",length = 10)
    private int age;
    @FieldDuo(columnName = "name",type = "varchar",length = 10)
    private String name;

    public Student2(){

    }

    public Student2(int id,int age,String name){
        this.id=id;
        this.age=age;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tableduo{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldDuo{
    String columnName();
    String type();
    int length();
}
