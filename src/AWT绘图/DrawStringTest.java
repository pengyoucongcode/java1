// >= JDK 1.8
// encoding:utf-8
// @software:IntelliJ IDEA
// @user:彭友聪
// @date:2019/08/15
// @time:下午 4:18
// @project:IDEA_JAVA
// @file:DrawStringTest.java
// @Author:御承扬
//@E-mail:2923616405@qq.com

package AWT绘图;

import javax.swing.*;
import java.awt.*;

public class DrawStringTest extends JFrame {
    static class CanvasTest extends Canvas {
        CanvasTest() {
        }

        public final void paint(Graphics g){
            super.paint( g );
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor( Color.BLUE );
            Font font = new Font( "楷体", Font.BOLD, 16 );
            g2.setFont( font );
            g2.drawString( "Done is better than perfect.", 20, 30 );
            g2.drawString( "——比完美更重要是完成。", 60, 60 );
        }
    }
    private DrawStringTest() {
        this.setSize( 310, 140 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        add(new CanvasTest());
        this.setTitle( "绘制文本" );
    }

    public static void main(String[] args) {
        DrawStringTest frame = new DrawStringTest();
        frame.setVisible( true );
    }
}
