package com.ssy.jvm.classLoader;

public class Test12 {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        System.out.println(cl);

        while (null != cl){
            cl = cl.getParent();
            System.out.println(cl);
        }
    }
}


