package com.ssy.jvm.classLoader;

/**
 * 当前类加载器：
 * 每一个类都会使用自己的类加载器去加载它所引用的类
 *
 * 线程上下文类加载器：
 * 线程上下文类加载器是从JDK1.2开始引入的，类Thread中的getContextClassLoader和setContextClassLoader
 * 分别用来获取和设置这个类。
 * 如果没有通过setContextClassLoader来设置的话，线程将继承其父线程的上下文类加载器。
 *  java应用运行时的初始线程的上下文类加载器是系统类加载器，在线程中运行的代码可以通过该类加载器来加载类与资源
 *
 * 线程上下文加载器的重要性：
 * 父ClassLoader可以使用当前线程Thread.currentTread().getContextClassLoader
 * ()所指定的ClassLoader加载的类，这就改变了双亲委托模型中的父加载器加载的类不能使用
 * 子加载器所加载的类或者是没有直接父子关系的ClassLoader加载的类的情况。
 *
 * 线程上下文类加载器就是当前线程的Current ClassLoader。
 * 在双亲委托模型下，类加载是由下至上的，即下层的类加载器会委托上层的类加载器进行加载，但对于SPI来说，
 * 有些接口是JAVA核心库所提供的，而java核心库是由启动类加载器来进行加载的，而这些接口的实现却来自于
 * 不同的厂家的jar包，java的启动类加载器是不会加载其他来源的jar包，这样传统的双亲委托模型就无法满足
 * SPI的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器来实现对于接口实现类的
 * 加载。
 */
public class Test18 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
