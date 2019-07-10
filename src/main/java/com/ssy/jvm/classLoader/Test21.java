package com.ssy.jvm.classLoader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @description TODO
 * @Author YouXu
 * @Date 2019/7/10 17:42
 **/
public class Test21 {
    public static void main(String[] args) throws Exception {
        Class<?> driverClass = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "passwd");
    }
}
