package com.ssy.jvm.classLoader;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/9 15:19
 **/
public class MyCat {
    public MyCat(){
        System.out.println("MyCat is loaded by:" + MyCat.class.getClassLoader());
    }
}
