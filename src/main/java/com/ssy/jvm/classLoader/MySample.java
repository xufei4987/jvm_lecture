package com.ssy.jvm.classLoader;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/9 15:20
 **/
public class MySample {
    public MySample(){
        System.out.println("MySample is loaded by:" + MySample.class.getClassLoader());

        new MyCat();
    }
}
