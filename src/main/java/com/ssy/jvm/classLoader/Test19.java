package com.ssy.jvm.classLoader;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/10 13:59
 **/
public class Test19 implements Runnable {
    private Thread thread;

    public Test19(){
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        ClassLoader contextClassLoader = thread.getContextClassLoader();

        thread.setContextClassLoader(contextClassLoader);

        System.out.println(contextClassLoader.getClass());

        System.out.println(contextClassLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new Test19();
    }
}
