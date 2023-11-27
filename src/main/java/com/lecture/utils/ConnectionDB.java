package com.lecture.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // tạo kết nối
    // khai báo thuộc tính Driver kết nối với MySQL
    private static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";
    // khai báo thuộc tính url kết nối
    private static final String url = "jdbc:mysql://localhost:3306/demo_jsp";
    // khai báo thuộc tính USER
    private static final String USER = "root";
    // khai báo thuộc tính PASSWORD
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // khai báo class cho driver

            Class.forName(DRIVER_JDBC);
            // mở kết nối
            connection = DriverManager.getConnection(url, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // đóng kết nối
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
