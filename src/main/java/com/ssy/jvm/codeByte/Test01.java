package com.ssy.jvm.codeByte;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/11 10:54
 *
 * 使用javap -verbose 分析一个字节码文件时，将会分析该字节码文件的魔数，版本号，常量池，类信息，类的构造方法，
 * 类中的方法信息，类变量与成员变量等信息。
 * 1、魔数：.class字节码文件的前4个字节，固定为0xCAFEBABE
 *
 * 2、版本信息：魔数后的4个字节，前2个字节minor version，后2个字节major version。（52对应java1.8，51对应1.7）
 *
 * 3、常量池（constant pool）：紧接着主版本号之后的就是常量池入口。一个java类中定义的很多信息都是由常量池来维护和
 * 描述的，可以将常量池看作Class文件的资源仓库，比如说JAVA类中定义的方法与变量信息，都是存储在常量池中。常量池中主要
 * 存储两类常量：字面量与符号引用。字面量如文本字符串，java中声明为final的常量值等，而符号引用如类和接口的全局限定名，
 * 字段的名称和描述符，方法的名称和描述符等。
 *
 * 4、常量池的总体结构：java类所对应的常量池主要由常量池数量与常量池数组这两部分组成。常量池数量紧跟在主版本号之后，占据
 * 2个字节；常量池数组则紧跟在常量池数量之后。常量池数组与一般的数组不同的是，常量池数组中不同的元素的类型、结构都是不同的，
 * 长度当然也是不同的；但是，每一种元素的第一个数据都是一个U1类型，该字节是个标志位，占据1个字节。jvm在解析常量池时，会
 * 根据这个U1类型来获取元素的具体类型。值得注意的是，常量池数组中的元素个数 = 常量池数 - 1 （其中0暂时不使用），目的是
 * 满足某些常量池索引值的数据在特定情况下需要表达【不引用任何一个常量池】的含义；根本原因在于，索引为0也是一个常量，只不过
 * 它不位于常量表中没这个常量就对应null值；所以，常量池的索引从1而非0开始。
 *
 * 5、在JVM规范中，每个变量/字段都有描述信息，描述信息主要的作用是描述字段的数据类型、方法的参数列表与返回值。根据描述的规则，
 * 基本数据类型和void类型都用一个大写字符来标示，对象类型则用L加对象的全限定名标示。（为了压缩字节码的体积）
 * B - byte, C - char, D - double, F - float, I - int, J - long, S - short, Z - boolean, V - void,
 * L - 对象类型，如Ljava/lang/String
 *
 * 6、对于数组类型来说，每一个维度使用UI个前置的[来表示，如int[]被记录为[I,String[][]被记录为[[Ljava/lang/String;
 *
 * 7、用描述符描述方法时，按照先参数列表，后返回值的顺序来描述。参数列表按照参数的严格顺序放在一组（）内，
 * 如方法：String getRealNameByIdAndNickName(int id, String name)的描述符为：(I, Ljava/lang/String;)Ljava/lang/String;
 **/
public class Test01 {

    public Test01() {
    }

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


}
