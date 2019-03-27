package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TodoConnection {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/todolistdb?useUnicode=true";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "pass";


    public static Connection getConnection(){
        Connection conn = null;
        try {
        	Class.forName(JDBC_DRIVER);
            conn =  DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            conn.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
