package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/06
//@time:下午 7:09
//@project:IDEA_JAVA
//@file:CustomMenuTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;


public class CustomMenuTest extends JFrame {
    public static void main(String[] args) {
        CustomMenuTest frame = new CustomMenuTest();
        frame.setVisible( true );
    }

    private CustomMenuTest() {
        super();
        setBounds( 100, 100, 500, 375 );
        setTitle( "个性化菜单示例" );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        final JMenuBar menuBar = new JMenuBar();
        setJMenuBar( menuBar );
        final JMenu fileMenu = new JMenu( "文件(F)" );    // 文件菜单
        fileMenu.setMnemonic( KeyEvent.VK_F );      // 设置快捷键
        menuBar.add(fileMenu);      // 将菜单添加到菜单栏中
        final JMenuItem newItem = new JMenuItem( "新建(N)" );
        newItem.setMnemonic( KeyEvent.VK_N );
        newItem.addActionListener( new ItemListener() );
        fileMenu.add( newItem );
        final JMenuItem openMenu = new JMenuItem( "打开(O)" );
        openMenu.setMnemonic( KeyEvent.VK_O );
        fileMenu.add(openMenu);
        // 创建子菜单项
        final JMenuItem openNewItem = new JMenuItem( "未打开过的(N)" );
        openNewItem.setMnemonic( KeyEvent.VK_N );
        openNewItem.addActionListener( new ItemListener() );
        openMenu.add(openNewItem);
        final JMenuItem openClosedItem = new JMenuItem( "刚打开过的(C)" );
        openClosedItem.setMnemonic( KeyEvent.VK_C );
        openClosedItem.setEnabled( false ); // 禁用菜单项
        openClosedItem.addActionListener( new ItemListener() );
        openMenu.add(openClosedItem);
        fileMenu.addSeparator();    // 添加分隔线
        final JMenuItem saveItem = new JMenuItem(  );
        saveItem.setText( "保存(S)" );
        saveItem.setMnemonic( KeyEvent.VK_S );
        saveItem.addActionListener( new ItemListener() );
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        final JMenuItem exitItem = new JMenuItem(  );
        exitItem.setText( "退出(E)" );
        exitItem.setMnemonic( KeyEvent.VK_E );
        exitItem.addActionListener( new ItemListener() );
        fileMenu.add(exitItem);
        final JMenu editMenu = new JMenu(  );
        editMenu.setText( "编辑(E)" );
        editMenu.setMnemonic( KeyEvent.VK_E );
        menuBar.add(editMenu);
        URL resource = this.getClass().getResource( "java3.jpg" );
        ImageIcon icon = new ImageIcon( resource );
        final JMenuItem cutItem = new JMenuItem( "剪切(T)" );
        cutItem.setIcon( icon );    // 设置图标
        cutItem.setMnemonic( KeyEvent.VK_T );
        cutItem.addActionListener( new ItemListener() );
        editMenu.add(cutItem);
        final JMenuItem copyItem = new JMenuItem( "复制(C)" );
        copyItem.setIcon( icon );
        copyItem.setMnemonic( KeyEvent.VK_C );
        copyItem.addActionListener( new ItemListener() );
        editMenu.add(copyItem);
        final JMenuItem pasteItem = new JMenuItem( "粘贴(P)" );
        pasteItem.setIcon( icon );
        pasteItem.setMnemonic( KeyEvent.VK_P );
        pasteItem.addActionListener( new ItemListener() );
        editMenu.add(pasteItem);
        editMenu.insertSeparator( 2 );  // 插入分隔线
        final JMenu helpMenu = new JMenu( "帮助(H)", false );
        helpMenu.setMnemonic( KeyEvent.VK_H );
        menuBar.add(helpMenu);
        final JMenuItem aboutItem = new JMenuItem( "关于(A)" );
        aboutItem.setMnemonic( KeyEvent.VK_A );
        aboutItem.addActionListener( new ItemListener() );
        helpMenu.add(aboutItem);
    }
    private static class ItemListener implements ActionListener {
        private ItemListener() {
        }

        public final void actionPerformed(ActionEvent e){
            JMenuItem menuItem = (JMenuItem)e.getSource();  // 获取单击的菜单项
            System.out.println( "你单击的菜单项："+menuItem.getText() );    // 显示单击菜单项的文本
        }
    }
}
