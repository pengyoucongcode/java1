package Network_communication;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Network_communication
//@user:彭友聪
//@date:2019/07/19
//@time:下午 5:05
//@project:IDEA_JAVA
//@file:Receive.java
//Author:御承扬
//email:2923616405@qq.com

import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class Receive extends JFrame implements Runnable,ActionListener{
    private int port; // 端口号存储变量
    private InetAddress group = null; // 声明 InetAddress 对象
    private MulticastSocket socket = null; // 创建多点套接字对象
    private JButton inner = new JButton( "开始接收" );
    private JButton stop = new JButton( "停止接收" );
    private JTextArea incedArea = new JTextArea( 10,10 ); // 显示接收广播的提示
    private JTextArea inced = new JTextArea( 10,10 ); // 显示接收到的广播
    private Thread thread; // 创建线程对象
    private boolean getMessage = true; // 是否接收广播
    private Receive() {
        super("广播数据报");
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        thread = new Thread( this ); // 实例化线程对象
        // 绑定“开始接收”和“停止接收”按钮的单击事件
        inner.addActionListener( this );
        stop.addActionListener( this );
        JPanel north = new JPanel(  ); // 创建 JPanel
        north.add( inner );
        north.add(stop);
        add(north,BorderLayout.NORTH);
        JPanel center = new JPanel(  );
        center.setLayout( new GridLayout( 1,2 ) );
        center.add( incedArea );
        final JScrollPane scrollPane = new JScrollPane(  );
        center.add(scrollPane);
        scrollPane.setViewportView( inced );
        add(center,BorderLayout.CENTER);
        validate();// 重新验证容器中的组件，即刷新组件
        port = 9898;
        try {
            group = InetAddress.getByName( "224.255.10.0" );
            socket = new MulticastSocket( port );
            socket.joinGroup( group );
        } catch (Exception e) {
            e.printStackTrace();
        }
        setBounds( 100,50,360,380 );
        setVisible( true );
    }

    public final void run() {
        while(getMessage) { // 循环接收广播报文，直到 getMessage 被改为 false
            byte[] data = new byte[1024];
            DatagramPacket packet = null;
            // 待接收的数据包
            packet = new DatagramPacket( data,data.length,group,port );
            try {
                socket.receive( packet );
                // 获取数据包中的内容，转换为字符串
                String message = new String(packet.getData(),0,packet.getLength());
                // 将接受内容显示在文本域中
                incedArea.setText( "正在接收的内容：\n"+message );
                inced.append( message+"\n" );
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }

    public final void actionPerformed(ActionEvent e){ // 按钮的单击事件
        if( e.getSource() == inner) {
            inner.setBackground( Color.red ); // 设置按钮颜色
            stop.setBackground( Color.yellow );
            if( !( thread.isAlive())) { // 如果线程不处于新建状态
                thread = new Thread( this );
                getMessage = true;
            }
            thread.start();
        }

        if( e.getSource() == stop ) {
            inner.setBackground( Color.yellow );
            stop.setBackground( Color.red );
            getMessage = false;
        }
    }

    public static void main(String[] args) {
        Receive rec = new Receive();
        rec.setSize(460,200);
    }
}
