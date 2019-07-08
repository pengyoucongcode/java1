package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/7/8
//@time:22:04
//@project:IDEA_JAVA
//@file:SleepMethodTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SleepMethodTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private Thread t;
    private static Color[] color = { Color.BLACK, Color.BLUE,Color.CYAN,Color.GREEN, Color.ORANGE,Color.YELLOW};
    private static final Random rand = new Random(  ); // 创建随机对象

    private static Color getC() { // 获取随机颜色值的方法
        // 随机产生一个color数组长度
        return color[rand.nextInt( color.length )];
    }

    private SleepMethodTest() {
        t = new Thread( new Draw() ); // 创建匿名线程对象
        t.start();
    }

    class Draw implements Runnable { // 定义内部类，用来在窗体中绘制线条
        int x = 30; // 定义初识坐标
        int y = 50;
        @Override
        public void run() { // 重写线程接口方法
            while(true) {
                try {
                    Thread.sleep( 100 ); //线程休眠0.1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取绘图组件上下文对象
                Graphics graphics = getGraphics();
                graphics.setColor( getC() ); // 设置绘图颜色
                // 绘制直线并递增垂直坐标
                graphics.drawLine( x,y,100, y );
                y++;
                if(y >= 80) {
                    y = 50;
                }
            }
        }
    }
    // 初识化程序界面
    public static void init(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setSize( width,height );
        frame.setVisible( true );
    }

    public static void main(String[] args) {
        init(new SleepMethodTest(),100,100);
    }
}
