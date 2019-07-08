package com.ssy.jvm.classLoader;

public class Test08 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block");
    }
}