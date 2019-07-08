package com.ssy.jvm.classLoader;

import java.net.URL;
import java.util.Enumeration;

public class Test13 {

    public static void main(String[] args) throws Exception{

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        String resourceName = "com/ssy/jvm/classLoader/Test11.class";
        Enumeration<URL> resources = contextClassLoader.getResources(resourceName);

        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url);
        }

        System.out.println("-----------");

        Class<?> clazz = Test13.class;
        System.out.println(clazz.getClassLoader());

        Class<?> clazz1 = String.class;
        System.out.println(clazz1.getClassLoader());
    }

}
