package Thread.Lamda;

import java.util.List;

/*
* 推到拉姆达表达式
* */
public class TestLamda {

    //3.静态内部类
    static class   Like1 implements ILike{
        @Override
        public void lamda() {
            System.out.println("i like Lamda1");
        }
    }


    public static void main(String[] args) {
        ILike iLike=new Like();
       // Like iLike=new Like();
        iLike.lamda();



        iLike=new Like1();
        iLike.lamda();


        //4.局部内部类
        class   Like2 implements ILike{
            @Override
            public void lamda() {
                System.out.println("i like Lamda2");
            }
        }

        iLike =new Like2();
        iLike.lamda();



        //5.匿名内部类:没有类的名称，必须借助接口或者父类
        iLike=new ILike() {
            @Override
            public void lamda() {
                System.out.println("i like Lamda3");
            }
        };
        iLike.lamda();


        //6.用拉姆达简化
        iLike=()-> {
            System.out.println("i like Lamda4");
        };
        iLike.lamda();
    }
}

//1.定义一个函数式接口
interface ILike{
    void lamda();
}

//2.实现类
class   Like implements ILike{

    @Override
    public void lamda() {
        System.out.println("i like Lamda");
    }
}