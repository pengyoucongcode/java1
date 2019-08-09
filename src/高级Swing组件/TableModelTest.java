package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/09
//@time:上午 10:11
//@project:IDEA_JAVA
//@file:TableModelTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableModelTest extends JFrame {
    private DefaultTableModel tableModel;   // 定义表格模型对象
    private JTable table;   // 表格对象
    private JTextField aTextField, bTextField;  // 面板下面的两个输入框
    private JButton addButton, delButton, updButton;    // 增删改三个按钮

    private TableModelTest() {
        super();
        setTitle( "维护表格模型示例" );
        setBounds( 100, 100, 500, 375 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        String[] columnNames = {"A", "B"};
        String[][] tableValues = {{"A1", "B1"}, {"A2", "B2"}, {"A3", "B3"}};

        tableModel = new DefaultTableModel( tableValues, columnNames );
        table = new JTable( tableModel );
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane, BorderLayout.CENTER );
        buttonInit();   // 按钮初始化
        addListener();  // 给组件添加监听事件
    }

    private void buttonInit() {
        final JPanel panel = new JPanel();
        getContentPane().add( panel, BorderLayout.SOUTH );
        panel.add( new JLabel( "A: " ) );
        aTextField = new JTextField( "A4", 10 );
        panel.add( aTextField );
        panel.add( new JLabel( "B: " ) );
        bTextField = new JTextField( "B4", 10 );
        panel.add( bTextField );
        addButton = new JButton( "添加" );
        updButton = new JButton( "修改" );
        delButton = new JButton( "删除" );
        panel.add( addButton );
        panel.add( updButton );
        panel.add( delButton );
    }

    private void addListener() {
        // 为表格模型添加事件监听器
        tableModel.addTableModelListener( new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int type = e.getType(); // 获取事件类型
                int row = e.getFirstRow() + 1;
                int column = e.getColumn() + 1;
                if (type == TableModelEvent.INSERT) {
                    System.out.println( "此次事件由 插入 触发" );
                    System.out.println( "此次插入的是第 " + row + " 行，第 " + column + " 列" );
                } else if (type == TableModelEvent.UPDATE) {
                    System.out.println( "此次事件由 修改 触发" );
                    System.out.println( "此次修改的是第 " + row + " 行，第 " + column + " 列" );
                } else if (type == TableModelEvent.DELETE) {
                    System.out.println( "此次事件由 删除 触发" );
                    System.out.println( "此次删除的是第 " + row + " 行，第 " + column + " 列" );
                } else {
                    System.out.println( "此次事件由 其他原因 触发" );
                }
            }
        } );
        // 添加按钮事件
        addButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] rowValues = {aTextField.getText(), bTextField.getText() };
                // 创建表格行数据
                tableModel.addRow( rowValues );
                int rowCount = table.getRowCount() + 1;
                aTextField.setText( "A " + rowCount );
                bTextField.setText( "B " + rowCount );
            }
        } );
        updButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.setValueAt( aTextField.getText(), selectedRow, 0 );
                    tableModel.setValueAt( bTextField.getText(), selectedRow, 1 );
                }
            }
        } );
        delButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow( selectedRow );
                }
            }
        } );
    }

    public static void main(String[] args) {
        TableModelTest frame = new TableModelTest();
        frame.setVisible( true );
    }
}
