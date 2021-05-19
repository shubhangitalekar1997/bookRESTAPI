package com.shubh.book.rest.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shubhangi.Talekar
 *
 */
public class DBConnect {

	private static DBConnect instance = new DBConnect();
	private static Connection con = null;

	private static String URL = "jdbc:h2:~/bookdb";
	private static String DRIVER = "org.h2.Driver";
	private static String USER = "sa";
	private static String PASSWORD = "";
	static {
		// load driver
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private Connection createConnection() {
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
