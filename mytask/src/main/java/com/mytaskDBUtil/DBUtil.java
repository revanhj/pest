package com.mytaskDBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private final static String user = "root";
	private final static String password = "root";
	private final static String url = "jdbc:mysql://localhost:3306/employee";

	public static Connection getConnection() throws SQLException {
		
		Connection con = DriverManager.getConnection(url, user, password);
		//con.setAutoCommit(false);
		return con;
	}
}
