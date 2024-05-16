package fr.stmichel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class DAOContext {
	private static String driver;
	private static String dbUrl;
	private static String login;
	private static String pwd;

	protected static Connection connect(){
		Connection con = null;
		if (driver != null && dbUrl != null && login != null && pwd != null) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(dbUrl, login, pwd);

			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void init(ServletContext context) {
		driver = context.getInitParameter("driver");
		dbUrl = context.getInitParameter("dbUrl");
		login = context.getInitParameter("login");
		pwd = context.getInitParameter("pwd");
	}
}
