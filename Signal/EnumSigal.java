package Thread.Signal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//enum是什么
public enum EnumSigal{
    INSTANCE;

    public EnumSigal getInstance(){
        return INSTANCE;
    }
}
class Tset{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSigal instance1=EnumSigal.INSTANCE;
        //EnumSigal instance2=EnumSigal.INSTANCE;
        Constructor<EnumSigal> declaredConstructor=EnumSigal.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        EnumSigal instance2=declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        //Constructor<EnumSigal> declaredConstructor=EnumSigal.class.getDeclaredConstructor()
    }
}
