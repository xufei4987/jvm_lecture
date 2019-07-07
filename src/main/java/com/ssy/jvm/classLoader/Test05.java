package com.ssy.jvm.classLoader;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候，才会初始化
 * 当一个类被初始化，它的接口是不会被初始化的
 */
public class Test05 {
    public static void main(String[] args) {
//        System.out.println(MyChild5.a);
//        new C();
//        new C();
        System.out.println(MyChild5.b);
    }
}

interface MyGrandpa{

    public static Thread THREAD = new Thread(){
        {
            System.out.println("MyGrandpa invoked");
        }
    };
}

interface MyParent5 extends MyGrandpa{
    //相当于public static final int a
//    int a = new Random().nextInt(3);
    public static Thread THREAD = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

class MyChild5 implements MyParent5{
    public static int b = 5;
}

class C {
    //实例代码块，每次创建实例都会执行
    {
        System.out.println("Hello");
    }
    public C(){
        System.out.println("C Initialization");
    }
}
