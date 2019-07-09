package com.ssy.jvm.classLoader;

import java.lang.reflect.Method;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/9 16:30
 * 类加载器的双亲委托模型的好处：
 * 1、可以确保Java核心库的类型安全，java核心类库的加载工作都是由启动类加载器来统一完成的，从而保证java应用所使用的都是同一个版本的核心类库。
 * 2、可以确保java核心类库不会被自定义的类所替代。
 * 3、可以利用类加载器命名空间的特性，在java虚拟机中并存多个类名完全相同的类，只需要不同的类加载器加载即可（不能为父子关系），相当于在虚拟机
 * 中创建了多个相互隔离的java类空间。
 **/
public class Test16 {
    public static void main(String[] args) throws Exception{

        MyClassLoader1 loader1 = new MyClassLoader1("loader1");
        loader1.setPath("C:/");
        MyClassLoader1 loader2 = new MyClassLoader1("loader2");
        loader2.setPath("C:/");
        Class<?> clazz1 = loader1.loadClass("com.ssy.jvm.classLoader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.ssy.jvm.classLoader.MyPerson");

        System.out.println(clazz1 == clazz2);
        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1,o2);
    }
}
