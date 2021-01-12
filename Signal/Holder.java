package Thread.Signal;

//静态内部类
public class Holder {
    private Holder(){

    }
    public static Holder getInstance(){
        return Innerclass.HOLDER;
    }
    public static class Innerclass{
        private static final Holder HOLDER=new Holder();
        public static void main(String[] args) {

        }
    }
}
