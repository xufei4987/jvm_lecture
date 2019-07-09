package com.ssy.jvm.classLoader;

import sun.misc.Launcher;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/9 17:13
 *
 * 在运行期，一个java类是由该类的完全限定名和用于加载该类的定义类加载器所共同决定的，所以两个类即便是完全限定名相同，如果是由
 * 不同的类加载器所加载，这两个类也是不同的。
 **/
public class Test17 {
    static {
        System.out.println("Test17 static block");
    }
    public static void main(String[] args) {
        System.out.println(Test01.class.getClassLoader());
        System.out.println(Test17.class.getClassLoader());

        System.out.println(ClassLoader.class.getClassLoader());
        //扩展类加载器和系统类加载器都是由启动类加载器加载的
        System.out.println(Launcher.class.getClassLoader());
    }
}
