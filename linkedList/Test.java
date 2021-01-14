package shujiazuoye.linkedList;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Linked link=new Linked();
        /*link.add(1);
        link.add(2);
        System.out.println(link.size());
        System.out.println(link.remove(2));
        System.out.println(link.size());*/

        link.insert(5);

        link.insert(3);

        link.insert(2);
        link.insert(9);
        link.insert(4);
        link.insert(7);
        link.insert(1);
        //1,2,3,4,5,7,9
        System.out.println(link.getHead().key);
        System.out.println(link.get(3).key);
        System.out.println(link.removeIndex(1));
        System.out.println(link.getHead().key);
        System.out.println(link.removeLastIndex(2));
        System.out.println(link.get(5).key);
    }


}
