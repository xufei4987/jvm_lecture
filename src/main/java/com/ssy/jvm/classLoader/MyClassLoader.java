package com.ssy.jvm.classLoader;

import java.io.*;
import java.net.URL;

public class MyClassLoader extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public MyClassLoader(String classLoaderName){
        super();//以系统类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName){
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
        return defineClass(bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name){

        byte[] data = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try{

            name = name.replace("+", "/");
            URL url = getResource(name + fileExtension);
            is = new FileInputStream(new File(url.getFile()));
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

    public static void test(ClassLoader cl) throws Exception{
        Class<?> clazz = cl.loadClass("com+ssy+jvm+classLoader+Test01");
        Object instance = clazz.newInstance();
        System.out.println(instance);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("myClassLoader");
        MyClassLoader.test(myClassLoader);
    }
}
