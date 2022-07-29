package com.edu.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCon {
	static Connection conn;

	public static Connection getConnect() {
		// InitialContext 생성
		InitialContext ic;
		try {
			ic = new InitialContext();
			// DataSource 생성
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
