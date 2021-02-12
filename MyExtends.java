package mapractice;

public class MyExtends extends my{

    @Override
    void say() {

    }
    public MyExtends(){
        System.out.println("i am agirl");
    }

    public static void main(String[] args) {
        MyExtends my=new MyExtends();
    }
}
abstract class  my{
    abstract  void say();
}