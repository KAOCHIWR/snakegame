package 贪吃蛇;

import javax.swing.*; //使用里面的类jpanel
import java.awt.*;

public class gamePanel extends JPanel {  //继承前面的面板才能自己改变画面

    //Graphics 是画笔让我们能改变画面
    @Override
    protected void paintComponent(Graphics g) {//重写这个方法
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK);//设置背景颜色
        date.header.paintIcon(this,g,25,11);

        //游戏区域
        g.fillRect(35,75,800,600);

    }
}
