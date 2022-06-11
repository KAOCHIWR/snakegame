package 贪吃蛇;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.white;

class Startgame  {
    static int time =100;//越大越慢
    static boolean flag = true;
    public static void main(String[] args) {
        //创造静态面板
        JFrame frame = new JFrame("贪吃蛇");//构造一个窗口，并显示游戏名字
        frame.setBounds(10, 10, 910, 730);//设置窗口的大小
        frame.setLocationRelativeTo(null);//显示屏幕中央
        frame.setResizable(false);//窗口大小不可以改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口可以关闭
        frame.setLayout (null);

        JLabel label1 = new JLabel("请选择贪吃蛇游戏难度");  //提示
        label1.setFont(new Font("华文琥珀",Font.BOLD,30));  //设置难度
        JLabel label2 = new JLabel();     //添加按钮
        label2.setFont(new Font("华文琥珀",Font.BOLD,20));
        label2.setForeground(Color.WHITE);
        label1.setBounds(270,200,500,50);
        label2.setBounds(270,100,500,50);
        JButton bt1 = new JButton("简单模式");  //按钮
        JButton bt2 = new JButton("正常模式");
        JButton bt3 = new JButton("困难模式");
        bt1.setBackground(Color.WHITE);//按钮选择颜色
        bt2.setBackground(Color.WHITE);
        bt3.setBackground(Color.WHITE);
        bt1.setBounds (350, 300, 150, 50);
        bt2.setBounds (350,370, 150, 50);
        bt3.setBounds (350,440, 150, 50);
        frame.add(label1);//添加到面板上面
        frame.add(label2);
        frame.add(bt1);
        frame.add(bt2);
        frame.add(bt3);
        bt1.addActionListener(new ActionListener() {  //重写监听器
            @Override
            public void actionPerformed(ActionEvent e) {  //实现对游戏难度的不同选择来提供不同的窗口
                System.out.println("简单模式");
                time=150;   //设置不同的速度来实现游戏的难度
                flag=!flag;
                frame.setVisible(flag);
                SnakeFrame snakeFrame = new SnakeFrame();
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("正常模式");
                time=100;
                flag=!flag;
                frame.setVisible(flag);
                SnakeFrame snakeFrame = new SnakeFrame();
            }
        });
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("困难模式");
                time=50;
                flag=!flag;
                frame.setVisible(flag);
                SnakeFrame snakeFrame = new SnakeFrame();
            }
        });

        //添加Jpanel
        frame.add(new gamePanel()); //导入自己改变的面板
        frame.setVisible(true);//打开窗口   GUI里面的
    }
}
