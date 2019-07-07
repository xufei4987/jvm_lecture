package com.ssy.jvm.classLoader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了。
 * -XX:+TraceClassLoading  追踪类的加载情况
 *
 * -XX:+<option> 开启option选项
 * -XX:-<option> 关闭option选项
 * -XX:<option>=<value> 设置option选项的值
 */
public class Test01  {

    public static void main(String[] args) {
        System.out.println(MyChild1.str1);
//        System.out.println(MyChild1.str2);
    }
}

class MyParent1{
    public static String str1 = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }

}

class MyChild1 extends MyParent1{

    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }

}
