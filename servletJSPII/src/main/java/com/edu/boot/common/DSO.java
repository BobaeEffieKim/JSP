package com.edu.boot.common;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class DSO {

//	ubuntu.
//	final static String DB_URL = "jdbc:oracle:thin:@db202112142040_medium?TNS_ADMIN=/home/leadon/Downloads/Wallet_DB202112142040";
//  pc
	final static String DB_URL = "jdbc:oracle:thin:@db202112142040_medium?TNS_ADMIN=D:/workspace/Wallet_DB202112142040";
	final static String DB_USER = "hr";
	final static String DB_PASSWORD = "H1q2w3e4r5tR";

	public OracleConnection connect() {

		Properties info = new Properties();
		info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
		info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
		info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

		OracleConnection conn = null;
		try {

			OracleDataSource ods = new OracleDataSource();
			ods.setURL(DB_URL);
			ods.setConnectionProperties(info);

			conn = (OracleConnection) ods.getConnection();

			// Get the JDBC driver name and version
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			// Print some connection properties
			System.out.println("Default Row Prefetch Value is: " + conn.getDefaultRowPrefetch());
			System.out.println("Database Username is: " + conn.getUserName());
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}
}
