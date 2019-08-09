package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/09
//@time:上午 8:09
//@project:IDEA_JAVA
//@file:JTableTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableTest extends JFrame {
    private JTable table;

    private JTableTest() {
        super();
        setTitle( "操作表格示例" );
        setBounds( 100, 100, 500, 375 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add( scrollPane, BorderLayout.CENTER );
        String[] columnNames = {"A", "B", "C", "D", "E", "F", "G"};     // 定义表格列
        String[][] tableValues = new String[20][columnNames.length];    // 定义数组，用于存储表格单元数据
        int len = columnNames.length;
        // 初始化表格数据
        for (int row = 0; row < 20; row++) {
            for (int column = 0; column < len; column++) {
                tableValues[row][column] = columnNames[column] + row;
            }
        }
        table = new JTable( tableValues, columnNames );
        table.setRowSelectionInterval( 1, 3 );   // 设置选中行
        table.addRowSelectionInterval( 5, 5 );   // 添加选中行
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        scrollPane.setViewportView( table );
        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        JButton selectedAllButton = new JButton( "全部选择" );
        selectedAllButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.selectAll();  // 选中所有行
            }
        } );
        buttonPanel.add( selectedAllButton );
        JButton clearSelectionButton = new JButton( "取消选择" );
        clearSelectionButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection(); // 取消选中行
            }
        } );
        buttonPanel.add( clearSelectionButton );
        // 输出表格的行数、列数
        System.out.println( "表格共有 " + table.getRowCount() + " 行 " + table.getColumnCount() );
        System.out.println( "第 3 行的选择状态为：" + table.isRowSelected( 2 ) );
        System.out.println( "被选中的第一行的索引是：" + table.getSelectedRow() );
        System.out.println( "第 2 列的名称是：" + table.getColumnName( 1 ) );
        System.out.println( "第 2 行 2 列的值为：" + table.getValueAt( 1, 1 ) );
    }

    public static void main(String[] args) {
        JTableTest frame = new JTableTest();
        frame.setVisible( true );
    }
}
