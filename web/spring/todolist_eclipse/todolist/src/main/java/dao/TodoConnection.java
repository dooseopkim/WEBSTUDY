package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TodoConnection {
    private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String dburl = "jdbc:mysql://localhost:3306/todolistdb?useUnicode=true";
    private static String dbUser = "root";
    private static String dbPasswd = "pass";


    public static Connection getConnection(){
        Connection conn = null;
        try {
        	Class.forName(jdbcDriver);
            conn =  DriverManager.getConnection(dburl,dbUser,dbPasswd);
            conn.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
