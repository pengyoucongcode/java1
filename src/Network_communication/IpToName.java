package Network_communication;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Network_communication
//@user:彭友聪
//@date:2019/07/18
//@time:下午 4:24
//@project:IDEA_JAVA
//@file:IpToName.java
//Author:御承扬
//email:2923616405@qq.com

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class IpToName {
    private IpToName() {

    }

    public static void main(String[] args) throws IOException {
        String IP;
        InetAddress host; // 创建 InetAddress 对象
        try {
            host = InetAddress.getLocalHost(); // 实例化 InetAddress 对象，获取本机的 IP 地址相关信息
            String localName = host.getHostName(); // 获取本机名
            String localIp = host.getHostAddress();
            System.out.println( "本机名:" + localName + ",本机 IP 地址：" + localIp );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        for (int i = 100; i <= 120; i++) {
            IP = "192.168.0." + i;
            try {
                host = InetAddress.getByName( IP );
                if( host.isReachable( 2000 )) { // 用两秒的时间测试 IP 是否可达
                    String hostName = host.getHostName(); // 获取指定 IP 地址的主机名
                    System.out.println( "IP 地址："+IP+"的主机名称："+hostName );
                }
            } catch ( UnknownHostException e) {
                e.printStackTrace();
            }
        }
        System.out.println( "搜寻完毕！！" );
    }
}
