package fr.stmichel;

import java.sql.*;
import jakarta.servlet.ServletContext;

public class DAOcontext {

    private static String DRIVER = "";
    private static String HOST = "";
    private static String DATABASE = "";
    private static String USER = "";
    private static String PASSWORD = "";

    public static void init(ServletContext context) {
        try {
            Class.forName(context.getInitParameter("mysqldriver"));
            DRIVER = context.getInitParameter("driver");
        	HOST = context.getInitParameter("host");
        	DATABASE = context.getInitParameter("database");
        	USER = context.getInitParameter("user");
        	PASSWORD = context.getInitParameter("password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DRIVER+"//"+HOST+"/"+DATABASE, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    protected static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

