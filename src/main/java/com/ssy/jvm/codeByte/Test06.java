package com.ssy.jvm.codeByte;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/13 15:39
 * 方法的动态分派
 *
 * 方法的动态分派涉及到一个重要的概念：方法接收者。
 *
 * invokevirtual字节码指令的多态查找流程：
 * 1、找到操作数栈顶的第一个元素，弹出并查找调用方法是否匹配，找到就直接调用，流程结束
 * 2、如果找不到就到父类中去匹配查找，找到就直接调用，找不到再找父类，以此类推
 * 3、都找不到则抛出异常
 * 方法重载（overload）与方法重写（overwrite）的区别：
 * 方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 **/
public class Test06 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {

    public void test(){
        System.out.println("Fruit");
    }

}

class Apple extends Fruit {

    public void test(){
        System.out.println("Apple");
    }

}

class Orange extends Fruit {

    public void test(){
        System.out.println("Orange");
    }

}