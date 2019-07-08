package com.ssy.jvm.classLoader;

/**
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对一个类的主动使用，不会导致类的初始化
 */

public class Test11 {
    public static void main(String[] args) throws Exception {
        ClassLoader systemClassLoader =
                ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.ssy.jvm.classLoader.CL");
        System.out.println(aClass);
        System.out.println("------------");
        //反射会导致类的初始化
        Class<?> aClass1 = Class.forName("com.ssy.jvm.classLoader.CL");
        System.out.println(aClass1);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
