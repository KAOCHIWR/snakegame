package 贪吃蛇;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SnakeFrame {

    SnakeFrame(){
        JFrame snframe = new JFrame("贪吃蛇");//绘制一个新的静态窗口
        snframe.setBounds(10,10,910,730);//窗口设置大小
        snframe.setResizable(false); //窗口不可变
        snframe.setLocationRelativeTo(null);//显示屏幕中央
        snframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件
        Button bt1 = new Button("Enter");//设置选择难的按钮
        bt1.setForeground(Color.black);
        bt1.setSize(50,50);
        bt1.setLocation(800,20);
        bt1.setBackground(Color.WHITE);
        snframe.add(bt1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("选择难度");
                //设置flag取反
                Startgame.flag=!Startgame.flag;
                try {
                    Method method = Startgame.class.getMethod("main",String[].class);
                    method.invoke(null,(Object) new String[] {});
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                //隐藏贪吃蛇画面
                snframe.setVisible(!Startgame.flag);

            }
        });
        //2.面板 JPanel  可以加入到JFrame
        snframe.add(new gamePanel());
        snframe.setVisible(!Startgame.flag);
    }

}
