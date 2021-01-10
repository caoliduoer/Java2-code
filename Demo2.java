package Thread.functionInterface;
import java.util.function.Predicate;
/*
* 判定型接口：有一个输入参数，返回值只能是 布尔值!
*
* */
public class Demo2 {

    public static void main(String[] args) {
        /*Predicate<String > predicate=new Predicate<String>(){
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*/
        Predicate<String> predicate=((s)->{return s.isEmpty();});//lambda表达式简化
        System.out.println(predicate.test("tt"));
    }
}
