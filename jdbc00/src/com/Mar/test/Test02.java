package com.Mar.test;

import com.Mar.beans.User;

import java.sql.*;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sjt2207";
        String username = "root";
        String password = "root";


        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from test";//?占位
        PreparedStatement ps = connection.prepareStatement(sql);
        //执行sql语句
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String password1 = rs.getString("password");
            int age = rs.getInt("age");
            User user = new User(id, name, password1, age);
            System.out.println(user);
        }

        ps.close();

        connection.close();
    }
}
