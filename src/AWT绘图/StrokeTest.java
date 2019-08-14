// >= JDK 1.8
// encoding:utf-8
// @software:IntelliJ IDEA
// @user:彭友聪
// @date:2019/08/14
// @time:下午 4:40
// @project:IDEA_JAVA
// @file:StrokeTest.java
// @Author:御承扬
//@E-mail:2923616405@qq.com

package AWT绘图;

import javax.swing.*;
import java.awt.*;

public class StrokeTest extends JFrame {
    static class CanvasTest extends Canvas {
        CanvasTest() {
        }

        public final void paint(Graphics g){
            super.paint( g );
            Graphics2D g2 = (Graphics2D) g;
            // 创建画笔，宽度为 8
            Stroke stroke = new BasicStroke( 8 );
            g2.setStroke( stroke );
            g2.drawLine( 20, 30, 120, 30 );
            // 创建画笔，宽度 12，线端点装饰用 CAP_ROUND，应用在路径线段交汇处的装饰为 JOIN_BEVEL
            Stroke roundStroke = new BasicStroke( 12, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL );
            g2.setStroke( roundStroke );
            g2.drawLine( 20, 50, 120, 50 );
        }
    }
    private void initialize(){
        this.setSize( 300,200 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        add(new CanvasTest());  // 设置窗体面板为绘图面板对象
        this.setTitle("设置画笔");
    }
    private StrokeTest() {
        super();
        initialize();
    }

    public static void main(String[] args) {

        StrokeTest frame = new StrokeTest();
        frame.setVisible( true );
    }
}
