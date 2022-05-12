package 贪吃蛇;

import javax.swing.*; //使用里面的类jpanel
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gamePanel extends JPanel implements KeyListener, ActionListener {  //继承前面的面板才能自己改变画面

    int lenth;
    int[] snakeX = new int [750];
    int[] snakey = new int [750];
    //生成随机的食物
    int foodx,foody;
    Random random =new Random();
    String fx ;   //设置方向
    boolean sfks = false;  //判断是否开始
    boolean sfFail = false; //游戏是否失败
    int score; //游戏的分数；
    Timer timer = new Timer(150,this);   //给时间的概念，1秒7.5帧，监听打开的窗口，实现接口

    //构造器来使用初始化的方法
    public gamePanel() {
        first();
        //开始键盘的接收
        this.setFocusable(true); //让键盘的焦点汇在屏幕上面
        this.addKeyListener(this);  //添加监听接口addKeyListerner这个类
        timer.start(); //调用计时器这个方法
        }

      public void first() {    //新的方法来初始化游戏值
        lenth = 3;
        snakeX[0] = 100; snakey[0] = 100;
        snakeX[1] = 75;  snakey[1] = 100;
        snakeX[2] = 50;  snakey[2] = 100;
        fx = "D";
        foodx = 25+25*random.nextInt(34);   //25+25*随机的一个数，但又不超过画面的食物
        foody = 75+25*random.nextInt(24);
        score=0;
    }

    //Graphics 是画笔让我们能改变画面,下面是更改画面
    @Override
    protected void paintComponent(Graphics g) {//重写这个方法
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);//设置背景颜色
        date.header.paintIcon(this,g,25,11); //设置标题，用paintIcon的方法把图片贴上去

        //游戏区域
        g.fillRect(25,75,850,600);
        //开始用paintIcon的方法来画蛇
        if (fx.equals("D")){    //equals()”比较字符串中所包含的内容是否相同然后来控制蛇头的方向
            date.right.paintIcon(this,g,snakeX[0],snakey[0] ); //右
        }  else if (fx.equals("A")) {
            date.left.paintIcon(this,g,snakeX[0],snakey[0] ); //左
        }  else if (fx.equals("W"))  {
            date.up.paintIcon(this,g,snakeX[0],snakey[0] );   //上
        } else if (fx.equals("S")) {
            date.down.paintIcon(this,g,snakeX[0],snakey[0] );  //下
        }

        for ( int i =1;i<lenth;i++ ) {
            date.body.paintIcon(this,g,snakeX[i],snakey[i] );  //蛇的长度可以用Length控制并且画出来
        }
        //判断游戏是否开始以及在面板上面显示东西
        if ( sfks == false ) {  //用g来画
            g.setColor(Color.WHITE);  //字体颜色
            g.setFont(new Font("Matura MT Script Capitals",Font.BOLD,50));//字体
            g.drawString("Press the space to begin",150,300);
        }
        date.food.paintIcon(this,g,foodx,foody);  //画食物
        g.setColor(Color.BLACK);
        g.setFont(new Font("Harlow Solid Italic",Font.PLAIN,18));
        g.drawString("lenth:"+lenth,750,35);
        g.drawString("score:"+score,750,50);

        if (sfFail) {  //游戏失败
            g.setColor(Color.WHITE);
            g.setFont(new Font("Matura MT Script Capitals",Font.PLAIN,90));
            g.drawString("GAME OVER",30,300);
            g.setFont(new Font("Rage Italic",Font.PLAIN,17));
            g.drawString("Press the space to begin",710,660);
        }

    }


    @Override //软件自动改正，让重写方法，实现对键盘的接听
    public void keyPressed(KeyEvent e) {  //按了键盘，但没有操作,自己改写来获取键盘按了什么
        int keycode = e.getKeyCode();

        if ( keycode == KeyEvent.VK_SPACE ) {   //根据获得的空格来控制游戏的暂停,开始，游戏失败的开始，然后刷新界面
            if(sfFail) {
                sfFail = false;
                first();//游戏失败后初始化重新开始新游戏
            }else {
                sfks = !sfks;
            }

            repaint();//用这个方法来刷新界面
        }

        //控制走向
        if ( keycode==KeyEvent.VK_LEFT ) {   //将键盘按的键转化成为程序可用的变量
             fx="A";
        } else if ( keycode==KeyEvent.VK_RIGHT ) {
            fx="D";
        } else if ( keycode==KeyEvent.VK_DOWN ) {
            fx="S";
        } else if ( keycode==KeyEvent.VK_UP) {
            fx="W";
        }

    }


    //监听时间，定时器
    @Override   //重写Timer的接口来进行执行定时操作让游戏动起来
    public void actionPerformed(ActionEvent e) {

        //游戏没有失败
        if (sfks&&sfFail==false) {
            for (int i =lenth-1;i>0;i--) {
                snakeX[i]=snakeX[i-1];
                snakey[i]=snakey[i-1];
            }
            //通过方向来改变头的移动
            if (fx.equals("D")) {  //右的指令
                snakeX[0]=snakeX[0]+25;
                if ( snakeX[0]>850 ) {  snakeX[0]=25; }
            } else if (fx.equals("A")) {  //左的指令
                snakeX[0]=snakeX[0]-25;
                if ( snakeX[0]<25 ) {  snakeX[0]=850; }
            } else if (fx.equals("W")) {  //上的指令
                snakey[0]=snakey[0]-25;
                if ( snakey[0]<75) {  snakey[0]=650; }
            } else if (fx.equals("S")) { //下的指令
                snakey[0]=snakey[0]+25;
                if ( snakey[0]>650 ) {  snakey[0]=75; }
            }

            //通过吃到食物增加长度,并且生成新食物
            if ( snakeX[0]==foodx&&snakey[0]==foody ) {
                lenth++;
                score+=10;
                foodx = 25+25*random.nextInt(34);  //生成新食物
                foody = 75+25*random.nextInt(24);
            }
            //判断是否失败
            for (int i =1;i<lenth;i++ ) {
                if ( snakeX[0]==snakeX[i]&&snakey[0]==snakey[i] ) {
                    sfFail=true;
                }
            }
            repaint();//刷新页面
        }

        timer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {  //按完之后
    }
    @Override
    public void keyTyped(KeyEvent e) { //按一下键盘可以实现一些操作
    }
    //监听功能，来接收键盘实现对游戏的控制

}
