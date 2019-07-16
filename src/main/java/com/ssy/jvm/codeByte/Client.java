package com.ssy.jvm.codeByte;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubject realSubject = new RealSubject();
        Class<?> cls = realSubject.getClass();
        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);
        Subject subjectProxy = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), dynamicSubject);
        subjectProxy.request();
        System.out.println(subjectProxy.getClass());
        System.out.println(subjectProxy.getClass().getSuperclass());
    }
}
