package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/08
//@time:上午 9:07
//@project:IDEA_JAVA
//@file:FileFilterTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FileFilterTest extends JFrame {
    private FileFilterTest(){
        super();
        setTitle( "选择照片对话框" );
        setBounds(100,100,500,375);
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        final JLabel label = new JLabel( "<双击选择照片>", SwingConstants.CENTER );
        label.addMouseListener( new MouseAdapter() {
            JFileChooser fileChooser;
            {
                fileChooser = new JFileChooser(  );
                // 设置文件过滤器，只列出JPG格式或GIF格式的图片
                FileFilter filter = new FileNameExtensionFilter( "图像文件（JPG/GIF）", "JPG", "GIF" );
                fileChooser.setFileFilter( filter );
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int i = fileChooser.showOpenDialog( getContentPane() );
                    if(i == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        label.setIcon( new ImageIcon( selectedFile.getAbsolutePath() ) );
                        label.setText( null );
                    }
                }
            }
        } );
        getContentPane().add(label, BorderLayout.CENTER );
    }

    public static void main(String[] args) {
        FileFilterTest frame = new FileFilterTest();
        frame.setVisible( true );
    }
}
