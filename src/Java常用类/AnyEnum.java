package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/15
//@time:15:52
//@project:IDEA_JAVA
//@file:AnyEnum.java
//Author:御承扬
//email:2923616405@qq.com

interface EnumInterface {
    public String getDescription();

    public int getI();
}

public enum AnyEnum implements EnumInterface {
    Constants_A {
        public String getDescription() {
            return ("我是枚举成员A");
        }

        public int getI() {
            return i;
        }
    },
    Constants_B{
        public String getDescription() {
            return ("我是枚举成员B");
        }

        public int getI() {
            return i;
        }
    },
    Constants_C{
        public String getDescription() {
            return ("我是枚举成员C");
        }

        public int getI() {
            return i;
        }
    },
    Constants_D{
        public String getDescription() {
            return ("我是枚举成员D");
        }

        public int getI() {
            return i;
        }
    };
    private static int i = 5;

    public static void main(String[] args) {
        AnyEnum array[] = AnyEnum.values();
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]+"调用getDescription()方法为："+array[i].getDescription());
            System.out.println(array[i]+"调用getI()方法为："+array[i].getI());
        }
    }
    }
