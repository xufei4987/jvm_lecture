package com.ssy.jvm.classLoader;

public class Test09 {
    public static void main(String[] args) {
        Parent9 parent9;

        System.out.println("-------------");

        parent9 = new Parent9();

        System.out.println("-------------");

        System.out.println(Parent9.a);

        System.out.println("-------------");

        System.out.println(Child9.b);
    }
}


class Parent9 {
    static int a = 3;
    static {
        System.out.println("parent9 static block");
    }
}

class Child9 extends Parent9 {
    static int b = 4;
    static {
        System.out.println("child9 static block");
    }
}