package com.ssy.jvm.classLoader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/10 14:10
 * 线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）
 *         ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
 *
 *         try {
 *             Thread.currentThread().setContextClassLoader(targetTccl);
 *             myMethod();
 *         }finally {
 *             Thread.currentThread().setContextClassLoader(contextClassLoader);
 *         }
 *
 * myMethod()调用了Thread.currentThread().getContextClassLoader()获取当前线程上下文类加载器完成类的加载工作。
 * 线程上下文类加载器的作用就是破坏JAVA的类加载的双亲委托机制。
 * 当高层提供了统一的接口让低层区实现，同时又要在高层加载或实例化低层的类时，就必须通过上下文类加载器来帮助高层的classloader
 * 找到并加载该类。
 **/
public class Test20 {
    public static void main(String[] args) {
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {

            Driver d = iterator.next();
            System.out.println("driver: " + d.getClass() + ", loader: " + d.getClass().getClassLoader());

        }

        System.out.println("当前线程的上下文加载器：" + Thread.currentThread().getContextClassLoader());
        System.out.println("serviceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
    }
}
