package Network_communication;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Network_communication
//@user:彭友聪
//@date:2019/07/19
//@time:下午 12:08
//@project:IDEA_JAVA
//@file:Client.java
//Author:御承扬
//email:2923616405@qq.com

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class Client {
    public Client() {
    }

    public static void main(String[] args) throws IOException {
        // 创建客户端套接字，通过指定端口连接服务器，连接本地服务器可以用本地回送 IP
        Socket client = new Socket("127.0.0.1",1100);
        System.out.println( "连接服务器成功！" );
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        try {
            out.write( "我是客户端，欢迎光临！".getBytes( StandardCharsets.UTF_8 ) );
            byte[] bt = new byte[1024];
            int len = in.read( bt );
            String data = new String(bt,0,len);
            System.out.println( "来自服务器的消息："+data );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.shutdownInput();
                client.shutdownOutput();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
