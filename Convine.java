package Try;

public class Convine {
    public static void main(String[] args) {
        System.out.println(0=='0');
        System.out.println(0=='\u0000');//true
        System.out.println('0'=='\u0000');
        System.out.println('8'=='5'+'3');
        System.out.println('8'=='5'+3);//true
        System.out.println(8=='5'+'3');
        System.out.println(8=='5'+3);
        //
        System.out.println("==========================================");

        long x=42L;
        long y=44L;
        System.out.println(""+7+2+"");
        System.out.println(foo()+x+5+"");
        System.out.println(x+y+foo());
    }

    static String foo() {
        return "foo";
    }
}
