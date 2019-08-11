package AWT绘图;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:AWT绘图
//@user:彭友聪
//@date:2019/08/11
//@time:上午 8:48
//@project:IDEA_JAVA
//@file:DrawTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawTest extends JFrame {
    static class CanvasTest extends Canvas {
        private CanvasTest(){
        }
        public final void paint(Graphics g){
            super.paint( g );
            Graphics2D g2 = (Graphics2D) g;
            g2.drawOval( 5, 5, 100, 100 ); // 绘制圆形
            g2.fillRect( 15, 15, 80, 80 ); // 绘制实心矩形
            Shape[] shapes = new Shape[2];  // 声明图形数组
            shapes[0] = new Rectangle2D.Double( 110, 5, 100, 100 );
            shapes[1] = new Ellipse2D.Double(120, 15, 80, 80);
            for(Shape shape : shapes) {     // 遍历数组
                Rectangle2D bounds = shape.getBounds2D();
                if (bounds.getWidth() == 80)
                    g2.fill( shape );   // 填充图形
                else
                    g2.draw(shape);  // 绘制图形
            }
        }
    }
    private void initialize() {
        this.setSize( 300, 200 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        add(new CanvasTest());
        this.setTitle( "绘制几何图形示例" );
    }
    private DrawTest() {
        super();
        initialize();
    }

    public static void main(String[] args) {
        new DrawTest().setVisible( true );
    }
}
