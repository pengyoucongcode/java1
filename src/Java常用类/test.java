package Java常用类;//Java常用类

//彭友聪
//2019/6/1
//19:59
//IDEA_JAVA
//email:2923616405@qq.com
public class test {
    private Object b;  //定义Object类型成员变量

    public Object getB() {
        return b;
    }

    public void setB(Object b) {
        this.b = b;
    }

    public static void main(String[] args) {
        test t = new test();
        t.setB(Boolean.TRUE);  //向上转型操作
        System.out.println(t.getB());
        t.setB(12.3f);
        Float f = (Float) (t.getB());  //向下转型操作
        System.out.println(f);
    }
}
