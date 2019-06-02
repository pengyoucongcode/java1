package Java常用类;//Java常用类

//彭友聪
//2019/6/2
//16:46
//IDEA_JAVA
//email:2923616405@qq.com
public class TrigonmetricFunction {
    public static void main(String[] args) {
        //取90°的正弦
        System.out.println("90 度的正弦值："+Math.sin(Math.PI/2));
        //取0°的余弦
        System.out.println("0 度的余弦值："+Math.cos(0));
        //取60°的正切
        System.out.println("60 度的正切值："+Math.tan(Math.PI/3));
        //取2的平方根与2的商的反正弦值
        System.out.println("2的平方根与2的商的反正弦值："+Math.asin(Math.sqrt(2)/2));
        //取2的平方根与2的商的反余弦值
        System.out.println("2的平方根与2的商的反余弦值："+Math.acos(Math.sqrt(2)/2));
        //取1的反正切值
        System.out.println("1的反正切值："+Math.atan(1));
        //取120°的弧度值
        System.out.println("取120°的弧度值:"+Math.toRadians(120.0));
        //π/2的角度
        System.out.println("π/2的角度值："+Math.toDegrees(Math.PI/2));
    }
}
