package Thread.functionInterface;
import java.util.function.Consumer;
/**
 * Consumer 消费型接口：只有输入，没有返回值
 */

public class Demo3 {
    public static void main(String[] args) {
        /*Consumer<String > consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*/
        Consumer<String> consumer=((str)->{
            System.out.println(str);
        });//lambda表达式简化
        consumer.accept("add");
    }
}
