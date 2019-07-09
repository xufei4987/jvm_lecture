package com.ssy.jvm.classLoader;

import java.io.*;

public class MyClassLoader1 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    public MyClassLoader1(String classLoaderName){
        super();//以系统类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader1(ClassLoader parent, String classLoaderName){
        super(parent);//以指定的类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = this.loadClassData(name);
        System.out.println("findClass....name="+name);
        return defineClass(null, bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name){

        byte[] data = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try{

            name = name.replace(".", "/");
            String filePath = this.path + name + this.fileExtension;
            is = new FileInputStream(new File(filePath));
            bos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())){
                bos.write(ch);
            }
            data = bos.toByteArray();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                is.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader1 myClassLoader = new MyClassLoader1("myClassLoader");
        myClassLoader.setPath("C:/");
        Class<?> clazz = myClassLoader.loadClass("com.ssy.jvm.classLoader.Test01");
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.hashCode());
        Object instance = clazz.newInstance();
        System.out.println(instance);

        myClassLoader = null;
        clazz = null;
        instance = null;
        System.gc();


        myClassLoader = new MyClassLoader1("myClassLoader");
        myClassLoader.setPath("C:/");
        clazz = myClassLoader.loadClass("com.ssy.jvm.classLoader.Test01");
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.hashCode());
        instance = clazz.newInstance();
        System.out.println(instance);


//        System.out.println("-----------------");
//
//        MyClassLoader myClassLoader1 = new MyClassLoader(myClassLoader,"myClassLoader1");
//        myClassLoader1.setPath("C:/");
//        Class<?> clazz1 = myClassLoader1.loadClass("com.ssy.jvm.classLoader.Test01");
//        System.out.println(clazz1.getClassLoader());
//        System.out.println(clazz1.hashCode());
//        Object instance1 = clazz1.newInstance();
//        System.out.println(instance1);
//
//        System.out.println("-----------------");
//
//        MyClassLoader myClassLoader2 = new MyClassLoader("myClassLoader2");
//        myClassLoader2.setPath("C:/");
//        Class<?> clazz2 = myClassLoader2.loadClass("com.ssy.jvm.classLoader.Test01");
//        System.out.println(clazz2.getClassLoader());
//        System.out.println(clazz2.hashCode());
//        Object instance2 = clazz2.newInstance();
//        System.out.println(instance2);
    }
}
