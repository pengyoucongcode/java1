package 高级事件处理;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级事件处理
//@user:彭友聪
//@date:2019/6/25
//@time:9:54
//@project:IDEA_JAVA
//@file:Focus.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Focus extends JFrame {
    private JLabel lbLight;
    private JLabel lbTip;


    public static void main(String[] args) {
        Focus frame = new Focus();
        frame.setVisible(true);
    }

    private class myWindowFocusListener implements WindowFocusListener {
        @Override
        public void windowGainedFocus(WindowEvent e) {
            // 设置标签中的图标，显示灯亮
            lbLight.setIcon(new ImageIcon(Focus.class.getResource("light.png")));
            lbTip.setText("JFrame 窗体获得焦点后，灯亮了。。。");
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            // 设置标签中的图标，显示灯灭
            lbLight.setIcon(new ImageIcon(Focus.class.getResource("dark.png")));
            lbTip.setText("JFrame 窗体失去焦点后，灯灭了...");
        }
    }

    private Focus() {
        addWindowFocusListener(new myWindowFocusListener());  // 为窗体添加焦点事件监听器
        setAutoRequestFocus(false);  // JFrame 窗体失去焦点
        setResizable(false);  // 卟可改变窗体大小
        setTitle("焦点事件的监听");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        // 创建JPanel面板contentPane置于JFrame窗体中，并设置面板的背景色、边距和布局

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        // 创建标签lblTip置于JFrame窗体中的南侧，设置标签label_1中字体的颜色、样式以及水平居中

        lbTip = new JLabel("JFrame 窗体失去焦点时，灯没亮！");
        lbTip.setForeground(Color.CYAN);
        lbTip.setFont(new Font("楷体", Font.PLAIN, 24));
        lbTip.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lbTip,BorderLayout.SOUTH);
        //  创建标签lblLight置于JFrame窗体中的中间，设置标签label_2中的图标位置和样式

        lbLight = new JLabel("");
        lbLight.setHorizontalAlignment(SwingConstants.CENTER);
        lbLight.setIcon(new ImageIcon(Focus.class.getResource("dark.png")));
        contentPane.add(lbLight,BorderLayout.NORTH);
    }
}
