package Thread.annotation;

import java.lang.annotation.*;

public class Tst1 {
    //注解可以显示赋值，如果有默认值，我们必须要给注解赋值
    @myAnnotation(name="duoduo",schools = {"清华"})
    public void test(){}
    @myAnnotation1("beijing")
    public void test2(){}
}
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME )
@interface myAnnotation{
//注解的参数:参数类型+参数名
    String name();
    int age() default 1;
    int id() default -1;//如果默认值为-1，代表不存在
    String[] schools();
}

@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME )
@ interface myAnnotation1{
    String value();//如果参数名字为value的时候，参数名可以省略，直接写参数值
}