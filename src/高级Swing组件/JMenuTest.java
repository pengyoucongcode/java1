package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/06
//@time:下午 3:17
//@project:IDEA_JAVA
//@file:JMenuTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private JMenuTest(){
        super();
        setTitle( "菜单栏示例" );
        setBounds( 100,100,500,375 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        JMenuBar menuBar = new JMenuBar();     // 创建菜单栏对象
        setJMenuBar( menuBar );     // 添加菜单栏对象到窗体中

        JMenu menu = new JMenu("菜单名称");// 创建菜单对象
        menuBar.add(menu);// 将菜单对象添加到菜单栏对象中

        JMenuItem menuItem = new JMenuItem("菜单项名称");// 创建菜单项对象
        menuItem.addActionListener(new ItemListener());// 为菜单项添加事件监听器
        menu.add(menuItem);// 将菜单项对象添加到菜单对象中

        JMenu sonMenu = new JMenu("子菜单名称");// 创建菜单的子菜单对象
        menu.add(sonMenu);// 将子菜单对象添加到上级菜单对象中

        JMenuItem sonMenuItem = new JMenuItem("子菜单项名称");// 创建子菜单的菜单项对象
        sonMenuItem.addActionListener(new ItemListener());// 为菜单项添加事件监听器
        sonMenu.add(sonMenuItem);// 将子菜单的菜单项对象添加到子菜单对象中

        JMenu menu2 = new JMenu("菜单名称2");// 创建菜单对象
        menuBar.add(menu2);// 将菜单对象添加到菜单栏对象中

        JMenuItem menuItem2 = new JMenuItem("菜单项名称2");// 创建菜单项对象
        menuItem2.addActionListener(new ItemListener());// 为菜单项添加事件监听器
        menu2.add(menuItem2);// 将菜单项对象添加到菜单对象中

        JMenu sonMenu2 = new JMenu("子菜单名称2");// 创建菜单的子菜单对象
        menu2.add(sonMenu2);// 将子菜单对象添加到上级菜单对象中

        JMenuItem sonMenuItem2 = new JMenuItem("子菜单项名称2");// 创建子菜单的菜单项对象
        sonMenuItem2.addActionListener(new ItemListener());// 为菜单项添加事件监听器
        sonMenu2.add(sonMenuItem2);// 将子菜单的菜单项对象添加到子菜单对象中
    }

    private class ItemListener implements ActionListener {
        private ItemListener() {
        }

        public final void actionPerformed(ActionEvent e) {
            JMenuItem menuItem = (JMenuItem) e.getSource();// 获得触发此次事件的菜单项
            System.out.println("您单击的是菜单项：" + menuItem.getText());// 获取菜单项文本
        }
    }

    public static void main(String[] args) {
        JMenuTest frame = new JMenuTest();
        frame.setVisible(true);
    }
}
