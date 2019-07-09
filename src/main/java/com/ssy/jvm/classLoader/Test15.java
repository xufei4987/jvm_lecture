package com.ssy.jvm.classLoader;

import java.util.Arrays;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/9 16:11
 **/
public class Test15 {
    public static void main(String[] args) {
        //根类加载器所加载的路径和jar包
        String[] boots = System.getProperty("sun.boot.class.path").split(";");
        Arrays.asList(boots).forEach(System.out::println);
        System.out.println("-------------");
        //扩展类加载器所加载的路径和jar包
        String[] exts = System.getProperty("java.ext.dirs").split(";");
        Arrays.asList(exts).forEach(System.out::println);
        System.out.println("-------------");
        //系统（应用）类加载器所加载的路径和jar包
        String[] paths = System.getProperty("java.class.path").split(";");
        Arrays.asList(paths).forEach(System.out::println);
    }
}
