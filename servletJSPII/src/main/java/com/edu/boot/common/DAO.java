package com.edu.boot.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String passwd = "hr";

	protected Connection conn;

	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
