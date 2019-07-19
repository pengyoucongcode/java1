package Network_communication;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Network_communication
//@user:彭友聪
//@date:2019/07/19
//@time:下午 4:48
//@project:IDEA_JAVA
//@file:BroadCast.java
//Author:御承扬
//email:2923616405@qq.com

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BroadCast extends Thread {
    private int port = 9898; // 定义端口，通过该端口进行数据的发送和接收
    private InetAddress address = null; // 用来指定主机所在多播组
    private MulticastSocket socket = null; // 声明多点广播套接字

    private BroadCast() {
        try {
            // 实例化 InetAddress，指定主机所在组，组的范围：224.0.0.0~239.255.255.255
            address = InetAddress.getByName( "224.255.10.0" );
            socket = new MulticastSocket( port );
            socket.setTimeToLive( 1 ); // 指定发送范围是本地网络
            socket.joinGroup( address );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void run() {
        while (true) {
            DatagramPacket packet; // 发送数据包
            Date now = new Date(  ); // 创建当前日期类
            SimpleDateFormat dateFormat = new SimpleDateFormat( "HH:mm:ss" );

            // 要发送的消息
            String broadcast = "("+dateFormat.format( now )+")节目预报：八点有大型晚会，请收听";
            byte[] data = broadcast.getBytes( StandardCharsets.UTF_8 );
            // 生成要发送的数据包
            packet = new DatagramPacket( data,data.length, address,port );
            System.out.println( new String(data) );
            try {
                socket.send(packet);
                sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BroadCast bCast = new BroadCast();
        bCast.start();
    }
}
