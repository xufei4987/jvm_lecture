package com.ssy.jvm.classLoader;

/**
 * 助记符：
 * ldc表示将int、float、String类型的常量从常量池中推送至栈顶
 * bipush表示将单字节（-128 - 127）的常量值推送至栈顶
 * sipush表示将一个短整形（-32768 - 32767）的常量值推送至栈顶
 * iconst_1表示将int类型的1推送至栈顶（iconst_m1(-1)、iconst_0 ~ iconst_5）单独为1-5创造了助记符
 */

public class Test02 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {

    //在编译阶段就放入了调用这个方法的类的常量池中
    //本质上，调用类并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
    //这里指的是将常量存放到了MyTest2的常量池中，之后Test02与MyParent2没有任何关系
    public static final String str = "hello world";

    public static final short s = 7;

    public static final int m = 1;

    static {
        System.out.println("MyParent2 static block");
    }
}
