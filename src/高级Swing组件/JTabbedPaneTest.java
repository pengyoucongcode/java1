package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/07/29
//@time:下午 4:38
//@project:IDEA_JAVA
//@file:JTabbedPaneTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTabbedPaneTest extends JFrame {
    private JPanel contentPane; // 窗体容器面板
    private JTabbedPane tabbedPane; // 选项卡面板
    private JRadioButton radioButtonTop; // “选项卡在顶部”单选按钮
    private AbstractButton abstractButtonDown; // “选项卡在底部”单选按钮
    private JRadioButton radioButtonLeft; // “选项卡在左侧”单选按钮
    private AbstractButton abstractButtonRight; // “选项卡在右侧”单选按钮
    private AbstractButton abstractButtonWrap; // 限制布局单选按钮
    private AbstractButton abstractButtonScroll; // 滚动布局按钮

    private JTabbedPaneTest() {
        setTitle( "演示选项卡面板" );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setBounds( 100,100,475,325 );
        // 创建内容面板，内容面板布局为边界布局。把选项卡面板放置在内容面板中间
        contentPane = new JPanel(  );
        tabbedPane = new JTabbedPane(  );
        contentPane.setBorder( new EmptyBorder( 5,5,5,5 ) ); // 无边框
        contentPane.setLayout( new BorderLayout( 0,0 ) );
        contentPane.add(tabbedPane,BorderLayout.CENTER);
        setContentPane( contentPane ); // 重新设置窗口容器

        buttonsInit(); // 按钮初始化
        tabbedPaneInit(); // 选项卡面板初始化
        addListener(); // 添加监听
        setVisible( true );
    }
    // 按钮初始化
    private void buttonsInit() {
        // 创建单选按钮面板。单选按钮面板为表格布局（8行1列），把单选按钮面板置于内容面板的西侧
        JPanel panel = new JPanel(  );
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout( new GridLayout( 8,1,0,0 ) );
        // “选项卡方向按钮”标签
        JLabel lblDirections = new JLabel( "选项卡方向按钮" );
        lblDirections.setHorizontalAlignment( SwingConstants.CENTER );
        lblDirections.setFont(new Font("华文楷体",Font.BOLD,14));
        panel.add( lblDirections );
        // “选项卡在顶部”单选按钮
        radioButtonTop = new JRadioButton( "选项卡在顶部" );
        radioButtonTop.setSelected( true ); // 设置默认被选中
        radioButtonTop.setFont(new Font("华文楷体",Font.PLAIN,14));
        panel.add( radioButtonTop );
        // "选项卡在底部“单选按钮
        abstractButtonDown = new JRadioButton( "选项卡在底部" );
        abstractButtonDown.setFont(new Font("华文楷体",Font.PLAIN,14));
        panel.add( abstractButtonDown );
        // “选项卡在左侧”单选按钮
        radioButtonLeft = new JRadioButton( "选项卡在左侧" );
        radioButtonLeft.setFont(new Font("华文楷体",Font.PLAIN,14));
        panel.add(radioButtonLeft);
        // “选项卡在右侧”单选按钮
        abstractButtonRight = new JRadioButton( "选项卡在右侧" );
        abstractButtonRight.setFont(new Font("华文楷体",Font.PLAIN,14));
        panel.add(abstractButtonRight);
        // 把选项卡的窗格位置：顶部、底部、左侧、右侧，添加到一个方向按钮组里
        ButtonGroup groupDirections = new ButtonGroup();
        groupDirections.add(radioButtonTop);
        groupDirections.add(abstractButtonDown);
        groupDirections.add(radioButtonLeft);
        groupDirections.add(abstractButtonRight);
        // “选项卡布局按钮”标签
        JLabel lblLayout = new JLabel( "选项卡布局按钮" );
        lblLayout.setHorizontalAlignment( SwingConstants.CENTER );
        lblLayout.setFont( new Font("华文楷体",Font.BOLD,14) );
        panel.add( lblLayout );
        // "限制布局”单选按钮
        abstractButtonWrap = new JRadioButton( "限制布局" );
        abstractButtonWrap.setSelected( true ); // 默认选中
        abstractButtonWrap.setFont(new Font("华文楷体",Font.PLAIN,14));
        panel.add( abstractButtonWrap );
        // “滚动布局”单选按钮
        abstractButtonScroll = new JRadioButton( "滚动布局" );
        abstractButtonScroll.setFont(new Font("华文楷体",Font.PLAIN,14));
        panel.add( abstractButtonScroll );
        // 把选项卡布局按钮添加到一个按钮组里
        ButtonGroup groupLayout = new ButtonGroup();
        groupLayout.add( abstractButtonWrap );
        groupLayout.add(abstractButtonScroll);
    }
    // 选项卡面板初始化
    private void tabbedPaneInit() {
        // 选项卡中的窗格内容（“罗永浩”）与标签内容（“我不是为了输赢，我就是认真”）
        JLabel lbLYH = new JLabel( "我不是为了输赢，我就是认真" );
        lbLYH.setFont(new Font("华文楷体",Font.PLAIN,14));
        lbLYH.setHorizontalAlignment( SwingConstants.CENTER );
        tabbedPane.addTab( "罗永浩", lbLYH );
        // 选项卡中的窗格内容（“乔帮主”）与标签内容（“Stay Hungry, Stay Foolish”）
        JLabel lbJobs = new JLabel( "Stay Hungry, Stay Foolish" );
        lbJobs.setFont(new Font("华文楷体",Font.PLAIN,14));
        lbJobs.setHorizontalAlignment( SwingConstants.CENTER );
        tabbedPane.addTab( "乔帮主", lbJobs );
        // 选项卡中的窗格内容（“罗振宇”）与标签内容（“死磕自己，愉悦大家”）
        JLabel lbLZY = new JLabel( "死磕自己，愉悦大家" );
        lbLZY.setFont(new Font("华文楷体",Font.PLAIN,14));
        lbLZY.setHorizontalAlignment( SwingConstants.CENTER );
        tabbedPane.addTab( "罗振宇", lbLZY );
    }
    // 监听方法
    private void addListener() {
        radioButtonTop.addActionListener( new ActionListener() { // 选项卡在顶部按钮添加监听
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setTabPlacement( SwingConstants.TOP ); // 设置选项卡窗格在顶部，以下皆类似
            }
        } );
        radioButtonLeft.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setTabPlacement( SwingConstants.LEFT );
            }
        } );
        abstractButtonRight.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setTabPlacement( SwingConstants.RIGHT );
            }
        } );
        abstractButtonDown.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setTabPlacement( SwingConstants.BOTTOM );
            }
        } );
        // 布局按钮添加监听
        abstractButtonWrap.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setTabLayoutPolicy( JTabbedPane.WRAP_TAB_LAYOUT );
            }
        } );
        abstractButtonScroll.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );
            }
        } );
    }

    public static void main(String[] args) {
        JTabbedPaneTest jt = new JTabbedPaneTest();
        jt.setVisible( true );
    }
}
