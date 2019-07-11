package com.ssy.jvm.codeByte;

public class Test02 {

    String str = "welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args){
        Test02 test02 = new Test02();

        test02.setX(8);

        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str){
        synchronized (str){
            System.out.println("hello world");
        }
    }

    private synchronized static void test2(){

    }

}
