package com.ssy.jvm.codeByte;

import java.util.Date;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/13 16:18
 * 针对于方法调用的动态分派过程，jvm会在类的方法区建立一个虚方法表的数据结构（virtual method table，vtable）
 * 针对于invokeinterface指令来说，jvm会建立一个叫做接口方法表的数据结构（interface method table，italbe）
 **/
public class Test07 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal{
    public void test(String str){
        System.out.println("Animal " + str);
    }

    public void test(Date date){
        System.out.println("Animal " + date);
    }
}

class Dog extends Animal{
    public void test(String str){
        System.out.println("Dog " + str);
    }

    public void test(Date date){
        System.out.println("Dog " + date);
    }
}