package com.ssy.jvm.classLoader;

/**
 * 执行顺序：
 * 1、准备阶段
 * counter1 = 0；
 * singleton = null；
 * counter2 = 0；
 * 2、初始化阶段
 * counter1 = 0；
 * singleton = new Singleton() -> counter1=1,counter2=1
 * counter2 = 0;
 */
public class Test06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:"  +Singleton.counter1);
        System.out.println("counter2:"  +Singleton.counter2);
    }
}
//类的初始化是顺序执行了
class Singleton {
    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance(){
        return singleton;
    }
}