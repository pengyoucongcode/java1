package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/07/28
//@time:下午 3:40
//@project:IDEA_JAVA
//@file:JSplitPaneTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.awt.*;
import javax.swing.*;
public class JSplitPaneTest extends JFrame{
    public JSplitPaneTest() {
        super();
        setTitle( "分割面板" );
        setBounds(100,100,500,375);
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        final JSplitPane hSplitPane = new JSplitPane(  ); // 创建一个（默认）水平方向的分割面板
        hSplitPane.setDividerLocation( 40 ); // 分隔条左侧宽度为 40 像素
        getContentPane().add(hSplitPane, BorderLayout.CENTER);
        hSplitPane.setLeftComponent( new JLabel( "    1" ) );
        final JSplitPane vSplitPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT ); // 创建一个垂直方向上的分割面板
        vSplitPane.setDividerLocation(30);
        vSplitPane.setDividerSize(8); // 分隔条宽度为 8 像素
        vSplitPane.setOneTouchExpandable( true ); // 提供 UI 小部件
        vSplitPane.setContinuousLayout( true ); // 设置分隔条移动时连续重绘，分隔条会跟随鼠标指针移动
        vSplitPane.setTopComponent( new JLabel( "    2" ) );
        vSplitPane.setBottomComponent( new JLabel( "   3" ) );
        hSplitPane.setRightComponent( vSplitPane ); // 将垂直分割面板添加到水平分割面板的右侧
    }

    public static void main(String[] args) {
        JSplitPaneTest frame = new JSplitPaneTest();
        frame.setVisible( true );
    }
}
