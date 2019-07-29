package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/07/29
//@time:下午 8:03
//@project:IDEA_JAVA
//@file:JInternalFrameTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

public class JInternalFrameTest extends JFrame {
    JDesktopPane desktopPane = null; // 定义一个桌面面板对象
    InternalFrame fontFrame = null; // 定义一个字体设置内部窗体对象
    InternalFrame colorFrame = null; // 定义一个颜色设置内部窗体
    InternalFrame styleFrame = null; // 定义一个格式设置内部窗体对象
    public static void main(String[] args) {
        JInternalFrameTest frameTest = new JInternalFrameTest();
        frameTest.setVisible( true );
    }
    // 构造方法
    private JInternalFrameTest() {
        super();
        // 创建窗体事件的监听
        this.addWindowListener( new DefinedListener(fontFrame,"内部窗体1","梦想和现实之间那段距离，叫做行动") );
        this.addWindowListener( new DefinedListener( colorFrame, "内部窗体2", "生活不是林黛玉，不会因为忧伤而风情万种" ) );
        this.addWindowListener( new DefinedListener( styleFrame, "内部窗体3", "Do or not. There is no try." ) );
        setTitle( "系统设置" );
        setBounds( 100,100,496,400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // 创建桌面面板对象
        desktopPane = new JDesktopPane();
        // 设置内部窗体的拖动模式，出现拖动的轮廓
        desktopPane.setDragMode( JDesktopPane.OUTLINE_DRAG_MODE );
        getContentPane().add( desktopPane, BorderLayout.CENTER );
    }

    // 窗体事件监听类
    private class DefinedListener implements WindowListener {
        InternalFrame inFrame; // 内部窗体
        String title; // 标题
        String content; // 内容

        public DefinedListener(InternalFrame inFrame, String title, String content) {
            this.inFrame = inFrame;
            this.title = title;
            this.content = content;
        }

        @Override
        public  void windowActivated(WindowEvent e) {
            /*
             * 如果内部窗体被关闭或为空，当主窗体重新进入活动状态时，
             * 重新加载内部窗体，保证内部窗体不会永远消失
             */
            if (inFrame == null || inFrame.isClosed()) {
                // 获得桌面面板中所有的内部窗体
                JInternalFrame[] allFrames = desktopPane.getAllFrames();
                int count = allFrames.length; // 获得桌面面板中拥有内部窗体数量
                int titleBarHeight = 30 * count; // 计算每个内部窗体的水平偏移量
                // 设置内部窗体的显示位置
                int x = 10 + titleBarHeight, y = x;
                int width = 250,height = 180; // 设置内部窗体的大小
                inFrame = new InternalFrame( title ); // 创建指定标题的内部窗体
                inFrame.setBounds( x,y,width,height );
                inFrame.setVisible( true ); // 使窗体可见
                inFrame.setLayout( new BorderLayout( 0,0 ) );
                JLabel label = new JLabel( content );
                label.setHorizontalAlignment( SwingConstants.CENTER );
                inFrame.add(label, BorderLayout.CENTER );
                desktopPane.add(inFrame);
            }
            try {
                inFrame.setSelected( true ); // 选中窗体
            } catch (PropertyVetoException p) {
                p.printStackTrace();
            }
        }

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    private  class InternalFrame extends JInternalFrame {
        InternalFrame(String title) {
            super();
            setTitle( title );
            setResizable( true );
            setClosable( true );
            setIconifiable( true );
            setMaximizable( true );
            ImageIcon icon = new ImageIcon( "in_frame.png" );
            setFrameIcon( icon );
        }
    }


}
