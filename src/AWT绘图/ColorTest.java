// >= JDK 1.8
// encoding:utf-8
// @software:IntelliJ IDEA
// @user:彭友聪
// @date:2019/08/14
// @time:下午 3:59
// @project:IDEA_JAVA
// @file:ColorTest.java
// @Author:御承扬
//@E-mail:2923616405@qq.com

package AWT绘图;

import javax.swing.*;
import java.awt.*;

public class ColorTest extends JFrame {
    static class CanvasTest extends Canvas {
        CanvasTest() {
        }

        public final void paint(Graphics g){
            super.paint( g );
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.drawLine( 5, 30, 100, 30 );
        }
    }
    private void initialize(){
        this.setSize( 300,200 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        add(new CanvasTest());  // 设置窗体面板为绘图面板对象
        this.setTitle("设置颜色");
    }
    public ColorTest() {
        super();
        initialize();
    }

    public static void main(String[] args) {

        ColorTest frame = new ColorTest();
        frame.setVisible( true );
    }
}
