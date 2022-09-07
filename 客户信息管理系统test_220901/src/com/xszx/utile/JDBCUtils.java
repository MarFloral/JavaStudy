package com.xszx.utile;

import java.sql.*;

public class JDBCUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/sjt2207";
    private static String username = "root";
    private static String password = "root";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //释放连接
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }

            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
