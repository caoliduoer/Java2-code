package CardWindows;

import javax.swing.*;
import java.awt.*;
public class CardWindow extends Frame{

    public static void main(String[] args) {
        Frame f=new Frame();
        //创建选择列表
        Panel cp=new Panel();
        JLabel l1=new JLabel("标签1");
        JLabel b2=new JLabel("标签2");
        JLabel j3=new JLabel("标签3");
        JLabel b=new JLabel("标签4");
        f.add(cp);
        f.setBounds(200,300,1000,500);
        f.setVisible(true);
        Thread t=new Thread(){
            @Override
            public void run() {
                while(true) {
                    try {b.setVisible(true);
                        l1.setVisible(true);
                        cp.add(l1);
                        cp.add(b);
                        //f.add(cp);
                        sleep(1000);
                        b.setVisible(false);//隐藏
                        l1.setVisible(false);
                        sleep(3000);
                    } catch (Exception e) {
                        return;
                    }
                }
            }
        };
        t.start();
        Thread t2=new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                         b2.setVisible(true);
                         j3.setVisible(true);
                        cp.add(b2);
                        cp.add(j3);
                        sleep(1000);
                        b2.setVisible(false);//隐藏
                        j3.setVisible(false);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        return;
                    }
                }
            }
        };
        t2.start();
    }
}
