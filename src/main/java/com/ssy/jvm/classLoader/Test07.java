package com.ssy.jvm.classLoader;

public class Test07 {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());

        Class<?> aClass1 = Class.forName("com.ssy.jvm.classLoader.Class07");
        System.out.println(aClass1.getClassLoader());
    }
}

class Class07 {

}