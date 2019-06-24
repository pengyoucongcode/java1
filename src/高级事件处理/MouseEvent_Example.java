package 高级事件处理;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:测试代码专用
//@user:彭友聪
//@date:2019/6/24
//@time:21:53
//@project:IDEA_JAVA
//@file:MouseEvent_Example.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEvent_Example extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) {
        MouseEvent_Example frame = new MouseEvent_Example();
        frame.setVisible(true); // 设置窗体可见，默认为不可见
    }

    private void mouseOper(MouseEvent e){
        int i = e.getButton(); // 通过该值可以判断按下的是哪个键
        if (i == MouseEvent.BUTTON1)
            System.out.println("按下的是鼠标左键");
        else if (i == MouseEvent.BUTTON2)
            System.out.println("按下的是鼠标滚轮");
        else if (i == MouseEvent.BUTTON3)
            System.out.println("按下的是鼠标右键");
    }

    private MouseEvent_Example(){
        super(); // 继承父类的构造方法
        setTitle("鼠标事件示例"); // 设置窗体的标题
        setBounds(100, 100, 500, 375); // 设置窗体的显示位置及大小
        // 设置窗体关闭按钮的动作为退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {// 光标移入组件时被触发
                System.out.println("光标移入组件");
            }

            public void mousePressed(MouseEvent e) {// 鼠标按键被按下时被触发
                System.out.print("鼠标按键被按下，");
                mouseOper(e);
            }

            public void mouseReleased(MouseEvent e) {// 鼠标按键被释放时被触发
                System.out.print("鼠标按键被释放，");
                mouseOper(e);
            }

            public void mouseClicked(MouseEvent e) {// 发生单击事件时被触发
                System.out.print("单击了鼠标按键，");
                mouseOper(e);
                int clickCount = e.getClickCount();//获取鼠标单击次数
                System.out.println("单击次数为" + clickCount + "下");
            }

            public void mouseExited(MouseEvent e) {// 光标移出组件时被触发
                System.out.println("光标移出组件");
            }
        });
        getContentPane().add(label, BorderLayout.CENTER);
        //
    }
}
