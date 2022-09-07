package com.Mar5.dao.impl;

import com.Mar5.beans.Book;
import com.Mar5.beans.Kind;
import com.Mar5.dao.BookDao;
import com.Mar5.test.Test;
import com.Mar5.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDaoImpl implements BookDao {
    private static String sql = Test.sql;
    private static PreparedStatement ps = Test.ps;
    private static Connection conn = Test.conn;
    private static ResultSet rs = Test.rs;

    @Override
    public void addBook(Book book) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into book values (null,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setString(4, book.getPress());
            ps.setString(5, book.getKind().getBname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public void deleteBook(int id) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "delete from book where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 0){
                System.out.println("该书不存在！");
            }else {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }



    @Override
    public void updateBook(Book book) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "update book set name = ?, author = ?,price = ?,press = ?,bname = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setString(4, book.getPress());
            ps.setString(5, book.getKind().getBname());
            ps.setInt(6, book.getId());
            int i1 = ps.executeUpdate();
            if (i1 == 0){
                System.out.println("该书不存在！");
            }else {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
    }

    @Override
    public ArrayList<Book> getBook(String name) {//按书名查询
        ArrayList<Book> books = new ArrayList<>();
        if ("查询全部".equals(name)) {
            try {
                conn = JDBCUtils.getConnection();
                sql = "select * from book";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String name2 = rs.getString("name");
                    String author = rs.getString("author");
                    String kind = rs.getString("bname");
                    double price = Double.parseDouble(rs.getString("price"));
                    String press = rs.getString("press");
                    int number = Integer.parseInt(rs.getString("number"));
                    Book book = new Book(id, name, author, price, press, new Kind(kind),number);
                    books.add(book);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                conn = JDBCUtils.getConnection();
                sql = "select * from book where name like concat('%', ? ,'%')";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
                if (rs.next()) {
                    rs.previous();
                    while (rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        String name2 = rs.getString("name");
                        String author = rs.getString("author");
                        String kind = rs.getString("bname");
                        double price = Double.parseDouble(rs.getString("price"));
                        String press = rs.getString("press");
                        int number = Integer.parseInt(rs.getString("number"));
                        Book book = new Book(id, name, author, price, press, new Kind(kind),number);
                        books.add(book);
                    }
                    return books;
                } else {
                    System.out.println("该书不存在！");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        JDBCUtils.release(conn,ps,rs);
        return null;
    }

    @Override
    public ArrayList<Book> getKBook(String kind) {//查询kind种类的书
        ArrayList<Book> books = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from bkind where bname = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,kind);
            rs = ps.executeQuery();
            if (rs.next()) {
                rs.previous();
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    double price = Double.parseDouble(rs.getString("price"));
                    String press = rs.getString("press");
                    int number = Integer.parseInt(rs.getString("number"));
                    Book book = new Book(id, name, author, price, press, new Kind(kind),number);
                    books.add(book);
                }
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.release(conn,ps,rs);
        return null;
    }

    @Override
    public Book decideBook(int id) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "select * from book where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                String press = rs.getString("press");
                String bname = rs.getString("bname");
                int number = rs.getInt("number");
                Book book = new Book(id1,name,author,price,press,new Kind(bname),number);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return null;
    }

    @Override
    public void down(int id) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "update book set number = number - 1 where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
    }



    @Override
    public void up(int id) {
        try {
            conn = JDBCUtils.getConnection();
            sql = "update book set number = number + 1 where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps,rs);
        }
    }

    @Override
    public ArrayList<Book> getBook(int i) {//按编号查询
        ArrayList<Book> books = new ArrayList<>();
        if (i == 0) {
            try {
                conn = JDBCUtils.getConnection();
                sql = "select * from book";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    rs.previous();
                    while (rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        String name = rs.getString("name");
                        String author = rs.getString("author");
                        String kind = rs.getString("bname");
                        double price = Double.parseDouble(rs.getString("price"));
                        String press = rs.getString("press");
                        int number = Integer.parseInt(rs.getString("number"));
                        books.add(new Book(id, name, author, price, press, new Kind(kind),number));
                    }
                    return books;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (i > 0) {
            try {
                conn = JDBCUtils.getConnection();
                sql = "select * from book where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, i + "");
                rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String kind = rs.getString("bname");
                    double price = Double.parseDouble(rs.getString("price"));
                    String press = rs.getString("press");
                    int number = Integer.parseInt(rs.getString("number"));
                    books.add(new Book(i, name, author, price, press, new Kind(kind),number));

                    return books;
                } else {
                    return books;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            return books;
        }
        JDBCUtils.release(conn,ps,rs);
        return books;
    }
}
