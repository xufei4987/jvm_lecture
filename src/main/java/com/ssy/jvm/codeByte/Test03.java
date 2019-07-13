package com.ssy.jvm.codeByte;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @description javap -verbose -p class文件
 * @Author YouXu
 * @Date 2019/7/12 16:39
 * 对于java类中的每一个实例方法，其在编译后所产生的字节码中，方法参数的数量总是会比源代码中的参数数量多一个（this），它位于方法
 * 的第一个参数位置处；这样我们就可以在java的实例方法中使用this来调用当前对象的成员方法与成员变量。
 *
 * 这个操作是在编译期间完成的，即由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问，接下来在运行期间，由
 * JVM调用实例的方法时，自动向实例方法传入该this参数，所以，在实例方法的局部变量表中，至少有一个指向当前对象的局部变量。
 *
 * java字节码对于异常的处理方式：
 * 1.统一采用异常表的方式来对异常进行处理。
 * 2.当异常处理存在finally语句块时，现代化的JVM采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面，
 * 换句话说，程序中存在多少个catch块，就会在每一个catch块后面重复多少个finally语句块的字节码。
 **/
public class Test03 {

    public void test() throws IOException,NullPointerException{

        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e){

        }finally {
            System.out.println("finally");
        }

    }

}
