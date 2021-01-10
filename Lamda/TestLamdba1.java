package Thread.Lamda;

public class TestLamdba1 {



    public static void main(String[] args) {
        //lamdba表达简化
        Ilove ilove=(int a)-> {
                System.out.println("i love you--->"+a);
            };
        //简化1：参数类型：
        ilove=(a)->{
            System.out.println("i love you--->"+a);
        };
        //简化2：简化括号
        ilove=a -> {
            System.out.println("i love you--->"+a);
        };
        //简化3：去掉花括号
        ilove=a -> System.out.println("i love you--->"+a);

        //总结：lamdba表达式只能有一行代码的情况下才能简化成一行，那么就用代码块包裹
        //     前提是接口为函数式接口
        //多个参数也可以去掉参数类型，要去都去掉。必须加上括号
        ilove.love(2);


    }

}
interface Ilove{
    void love(int a);
}
class Love implements Ilove{
    @Override
    public void love(int a) {
        System.out.println("i love you--->"+a);
    }
}
