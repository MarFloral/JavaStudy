package com.Mar.text;

import com.Mar.controller.UserController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    public static Connection conn = null;
    public static PreparedStatement ps  =null;
    public static ResultSet rs =null;
    public static String sql = null;
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.login();
    }
}
