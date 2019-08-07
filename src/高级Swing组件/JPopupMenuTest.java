package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/07
//@time:上午 9:02
//@project:IDEA_JAVA
//@file:JPopupMenuTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPopupMenuTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private static class ItemListener implements ActionListener {
        private ItemListener() {
        }

        public final void actionPerformed(ActionEvent e) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            System.out.println( "被单击的菜单项是："+menuItem.getText() );
        }
    }
    private JPopupMenuTest() {
        super();
        setTitle( "弹出菜单示例" );
        setBounds( 100,100,500,375 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        final JLabel label = new JLabel(  );
        label.setText( "            请在窗口中单击鼠标右键！" );
        getContentPane().add(label, BorderLayout.CENTER );

        final JPopupMenu popupMenu = new JPopupMenu(  );    // 创建弹出式菜单
        // 为窗体的顶层容器添加鼠标事件监听器
        getContentPane().addMouseListener( new MouseAdapter() {
            // 鼠标按键被释放时触发该方法
            @Override
            public void mouseReleased(MouseEvent e) {
                // 判断此次鼠标事件是否为该组件的弹出菜单触发事件
                // 如果是则在释放鼠标的位置弹出菜单
                if(e.isPopupTrigger())
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        } );
        final JMenuItem cutItem = new JMenuItem("剪切");
        cutItem.addActionListener(new ItemListener());
        popupMenu.add(cutItem);

        final JMenuItem copyItem = new JMenuItem("复制");
        copyItem.addActionListener(new ItemListener());
        popupMenu.add(copyItem);

        final JMenuItem pastItem = new JMenuItem("粘贴");
        pastItem.addActionListener(new ItemListener());
        popupMenu.add(pastItem);

        final JMenu editMenu = new JMenu("编辑");
        popupMenu.add(editMenu);

        final JMenuItem readItem = new JMenuItem("只读");
        readItem.addActionListener(new ItemListener());
        editMenu.add(readItem);

        final JMenuItem writeItem = new JMenuItem("可写");
        writeItem.addActionListener(new ItemListener());
        editMenu.add(writeItem);

        final JMenu fontMenu = new JMenu("字体");
        editMenu.add(fontMenu);

        final JMenuItem boldfacedItem = new JMenuItem("加粗");
        boldfacedItem.addActionListener(new ItemListener());
        fontMenu.add(boldfacedItem);

        final JMenuItem italicItem = new JMenuItem("斜体");
        italicItem.addActionListener(new ItemListener());
        fontMenu.add(italicItem);
    }

    public static void main(String[] args) {
        JPopupMenuTest frame = new JPopupMenuTest();
        frame.setVisible( true );
    }
}
