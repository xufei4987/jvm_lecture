package com.ssy.jvm.classLoader;

/**
 * 关于命名空间的说明：
 * 子加载器所加载的类能够访问到父加载器所加载的类
 * 父加载器所加载的类不能访问子加载器所加载的类
 * 子加载器的命名空间包含父加载器的命名空间
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/9 15:23
 **/
public class MyTest14 {


    public static void main(String[] args) throws Exception{
        MyClassLoader1 classLoader1 = new MyClassLoader1("MyClassLoader1");
        classLoader1.setPath("C:/");
        Class<?> clazz1 = classLoader1.loadClass("com.ssy.jvm.classLoader.MySample");
        System.out.println(clazz1.hashCode());
        Object o = clazz1.newInstance();
        System.out.println(o);
    }


}
