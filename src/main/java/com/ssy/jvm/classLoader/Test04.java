package com.ssy.jvm.classLoader;

/**
 * 对于的数组的实例来说，其类型是有JVM在运行期间动态生成的，
 * 表示为[Lcom.ssy.jvm.classLoader.MyParent4这种形式，
 * 动态生成的类型，其父类型就是object
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素为component，实际上就是将数组降低一个维度
 * 后的类型.
 *
 * 助记符：
 * anewarray：表示创建一个引用类型的（如类、接口、数组），并将其引用值压入栈顶
 * newarray: 表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引用值压入栈顶
 */
public class Test04 {
    public static void main(String[] args) {
        //创建类的数据不会导致类的初始化
        MyParent4[] myParent4s = new MyParent4[10];
        //class [Lcom.ssy.jvm.classLoader.MyParent4 jvm帮组生成的数组类型
        System.out.println(myParent4s.getClass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        //class [[Lcom.ssy.jvm.classLoader.MyParent4 jvm帮组生成的二维数组类型
        System.out.println(myParent4s1.getClass());
        //class java.lang.Object
        System.out.println(myParent4s.getClass().getSuperclass());


        int[] ints = new int[1];
        //class [I
        System.out.println(ints.getClass());
        //class java.lang.Object
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        //class [C
        System.out.println(chars.getClass());
    }
}

class MyParent4 {
    static{
        System.out.println("MyParent4 static block");
    }
}
