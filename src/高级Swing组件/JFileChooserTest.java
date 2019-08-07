package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/07
//@time:下午 8:25
//@project:IDEA_JAVA
//@file:JFileChooserTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFileChooserTest extends JFrame {
    private JTextField textField;
    private JFileChooserTest() {
        super();
        setTitle("文件选择器对话框示例");
        setBounds(100,100,600,375);
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        final JPanel panel = new JPanel(  );
        getContentPane().add(panel, BorderLayout.NORTH );

        final JLabel label = new JLabel( "文件:" );
        panel.add(label);

        textField = new JTextField(  );
        textField.setColumns( 20 );
        panel.add(textField);
        final JButton button = new JButton( "上传" );
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(  );    // 创建文件选择对话框
                int i = fileChooser.showOpenDialog( getContentPane() );     // 显示文件选择对话框
                if(i == JFileChooser.APPROVE_OPTION){   // 判断用户单击的是否为“打开”按钮
                    File selectedFile = fileChooser.getSelectedFile();  // 获得选中的文件对象
                    textField.setText( selectedFile.getName() );    // 显示选中文件的名称
                }
            }
        } );
        panel.add( button );
    }

    public static void main(String[] args) {
        JFileChooserTest frame = new JFileChooserTest();
        frame.setVisible( true );
    }
}
