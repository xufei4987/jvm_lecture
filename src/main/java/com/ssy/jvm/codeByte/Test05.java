package com.ssy.jvm.codeByte;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/13 15:25
 * 方法的静态分派
 * GrandPa g1 = new Father();
 * 以上代码，g1的静态类型是GrandPa，而g1的实际类型（真正指向的类型）是Father。
 * 结论：变量的静态类型是不会发生变化的，而变量的实际类型是可以发生变化的，这就是多态的一种体现，实际类型是在运行期
 * 确定的。
 **/
public class Test05 {

    //方法重载，是一种静态的行为，编译期间就可以完全的确定。
    public void test(GrandPa grandPa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        GrandPa g1 = new Father();
        GrandPa g2 = new Son();
        Test05 test05 = new Test05();
        test05.test(g1);
        test05.test(g2);
    }

}

class GrandPa {

}

class Father extends GrandPa {

}

class Son extends Father {

}