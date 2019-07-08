package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/7/1
//@time:10:49
//@project:IDEA_JAVA
//@file:SwingAndThread.java
//Author:御承扬
//email:2923616405@qq.com

import java.awt.Container;
import java.net.URL;
import javax.swing.*;


public class SwingAndThread extends JFrame{
    private JLabel jl = new JLabel(  );
    private int count = 0; // 声明计数变量
    private Container container;

    {
        container = getContentPane();
    }

    private SwingAndThread() {
        setBounds( 300,200,250,100 );
        container.setLayout( null ); // 使用绝对布局
        try {
            URL url = SwingAndThread.class.getResource( "1.gif" );
            Icon icon = new ImageIcon( url );
            jl.setIcon( icon );
        } catch (NullPointerException ex) {
            System.out.println( "图片不存在！！" );
        }
        jl.setHorizontalAlignment( SwingConstants.LEFT );
        jl.setBounds( 10,10,200,50 );
        jl.setOpaque( true );
        // 声明线程对象
        Thread t = new Thread( new Roll() );
        t.start();
        container.add(jl);
        setVisible( true );
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
    }

    class Roll implements Runnable {

        Roll() {
        }

        @Override
        public final void run() {
            while (count <= 200) {
                // 将标签的横坐标用变量表示
                jl.setBounds( count,10,200,50 );
                try {
                    Thread.sleep( 1000 ); // 为了体现滚动效果，使线程休眠 1000 毫秒
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count += 4;
                if (count == 200) {
                    // 当图标到达标签最右边时，使其回到标签最左边
                    count = 10;
                }
            }
        }

    }
    public static void main(String[] args) {
        new SwingAndThread();
    }
}
