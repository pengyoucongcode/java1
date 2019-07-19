package Network_communication;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Network_communication
//@user:彭友聪
//@date:2019/07/19
//@time:上午 11:19
//@project:IDEA_JAVA
//@file:Server.java
//Author:御承扬
//email:2923616405@qq.com

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;


public class Server {
    public Server() {
    }

    public static void main(String[] args) throws IOException {
        // 创建服务器对象，监听 1100 端口
        ServerSocket server = new ServerSocket( 1100 );
        System.out.println( "服务器启动成功，等待用户接入。。。。。" );
        //等待用户接入，直到用户接入为止
        Socket client = server.accept();
    try {
            // 等到接入客户端的 IP 地址
            System.out.println( "有客户端接入，客户 IP："+client.getInetAddress() );
            // 从客户端生成网络输入流，用于接收来自网络的数据
            InputStream in = client.getInputStream();
            // 从客户端生成输出流，用来把数据发送到网络
            OutputStream out = client.getOutputStream();
            byte[] bt = new byte[1024];
            int len = in.read(bt);
            String data = new String(bt,0,len);
            System.out.println( "来自客户端的信息："+data );
            //服务器发送数据
            out.write("我是服务器，欢迎光临".getBytes( Charset.forName( "UTF-8" ) ));
            out.flush();
            client.shutdownInput();
            client.shutdownOutput();

        } catch (IOException e) {
        e.printStackTrace();
        } finally {
         try{
             // 关闭套接字
            client.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
         }
    }
}
