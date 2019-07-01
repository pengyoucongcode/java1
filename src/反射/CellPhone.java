package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/30
//@time:21:01
//@project:IDEA_JAVA
//@file:CellPhone.java
//Author:御承扬
//email:2923616405@qq.com


public class CellPhone {
    @PhoneAnnotation(remarks = "品牌型号")
    public String brdMdl;  // 属性注释中的备注值为“品牌型号”，是否启用为默认值
    @PhoneAnnotation(remarks = "价格")
    public double price; // 属性注释中的备注值为“价格”，是否启用为默认值
    @Deprecated // 将此属性设置为过时
    @PhoneAnnotation(remarks = "电池接口", enable = false)
    public String batteryInter;  // 属性注释中备注值为“电池接口”，是否启用为不启用
    @PhoneAnnotation(remarks = "手机厂商")
    String produceArea; // 属性注释中备注值为“手机厂商”，是否启用默认值
}
