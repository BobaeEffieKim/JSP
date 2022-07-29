package com.dev;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.edu.boot.common.DSO;

import oracle.jdbc.OracleConnection;

public class Common {
	public static void main(String[] args) {
		DSO dso = new DSO();
		OracleConnection conn = dso.connect();
		Map<String, String> map = new HashMap<String, String>();
		try {
			PreparedStatement psmt = conn.prepareStatement("select * from employees");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getString("first_name"), rs.getString("last_name"));
			}

			Set<String> set = map.keySet();
			for (String key : set) {
				System.out.println("key: " + key);
				System.out.println("value: " + map.get(key));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
