package com.ssy.jvm.classLoader;

public class Test10 {
    public static void main(String[] args) {
        System.out.println(Child10.a);
        Child10.doSomething();
    }
}

class Parent10{
    static int a = 3;
    static{
        System.out.println("Parent10 static block");
    }
    static void doSomething(){
        System.out.println("do something");
    }
}

class Child10 extends Parent10{
    static {
        System.out.println("Child10 static block");
    }
}
