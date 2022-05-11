package 贪吃蛇;

import javax.swing.*;

public class Startgame  {
    public static void main(String[] args) {
        //创造静态面板
        JFrame frame = new JFrame("贪吃蛇SS");//构造一个窗口，并显示游戏名字
        frame.setBounds(10, 10, 910, 730);//设置窗口的大小
        frame.setResizable(false);//窗口大小不可以改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口可以关闭
        //添加Jpanel
        frame.add(new gamePanel()); //导入自己改变的面板
        frame.setVisible(true);//打开窗口   GUI里面的
    }
}
