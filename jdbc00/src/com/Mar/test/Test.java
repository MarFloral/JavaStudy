package com.Mar.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sjt2207";
        String usename = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, usename, password);

        String sql = "insert into test values (null,?,?,?)";//?占位
        PreparedStatement ps = connection.prepareStatement(sql);
        //替换sql中的?占位符
        ps.setString(1,"ls");
        ps.setString(2,"5");
        ps.setInt(3,16);
        //执行sql语句
        ps.execute();
//        ps.executeUpdate();
//        ps.executeQuery();

        ps.close();

        connection.close();


    }
}
