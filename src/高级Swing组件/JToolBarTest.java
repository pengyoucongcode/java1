package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/07
//@time:下午 12:06
//@project:IDEA_JAVA
//@file:JToolBarTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JToolBarTest extends JFrame {
    private static class ButtonListener implements ActionListener{
        private ButtonListener() {
        }

        public final void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            System.out.println( "被单击的是："+button.getText() );
        }
    }
    private JToolBarTest() {
        super();
        setTitle( "工具栏示例" );
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setVisible( true );
        final JToolBar toolBar = new JToolBar("工具栏");// 创建工具栏对象
        toolBar.setFloatable(true);// 设置为允许拖动
        getContentPane().add(toolBar, BorderLayout.NORTH);// 添加到网格布局的上方
        final JButton newButton = new JButton("新建");// 创建按钮对象
        newButton.addActionListener(new ButtonListener());// 添加动作事件监听器
        toolBar.add(newButton);// 添加到工具栏中
        toolBar.addSeparator();// 添加默认大小的分隔符
        final JButton saveButton = new JButton("保存");// 创建按钮对象
        saveButton.addActionListener(new ButtonListener());// 添加动作事件监听器
        toolBar.add(saveButton);// 添加到工具栏中
        toolBar.addSeparator(new Dimension(20, 0));// 添加指定大小的分隔符
        final JButton exitButton = new JButton("退出");// 创建按钮对象
        exitButton.addActionListener(new ButtonListener());// 添加动作事件监听器
        toolBar.add(exitButton);// 添加到工具栏中
    }

    public static void main(String[] args) {
        JToolBarTest frame = new JToolBarTest();
    }
}
