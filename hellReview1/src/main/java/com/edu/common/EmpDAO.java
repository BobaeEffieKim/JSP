package com.edu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO{

	public boolean updateMember(String name, String pass, String role) {
		String sql ="update members set member_password=?, "
				+ "member_role=? where member_id=?";
		
		try {
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 변경됨.");
			if(r>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	 public boolean insertMember(String name, String pass, String role) {
	      String sql="insert into members values(?,?,?)";
	      connect();
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1,name);
	         pstmt.setString(2,pass);
	         pstmt.setString(3,role);
	         int r = pstmt.executeUpdate(); //insert, update, delete
	         System.out.println(r+"건 입력됨");
	         if (r>0) 
	            return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return false;
	   }
	   

		public List<Employee> getEmpInfo(String name) {
			String sql = "select * from employees where first_name=?";
			connect(); //conn객체
			List<Employee> list = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setHireDate(rs.getDate("hire_date"));
					emp.setSalary(rs.getInt("salary"));
					emp.setJobId(rs.getString("job_id"));
					
					list.add(emp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return list;
		}
		
		public List<Employee> empList(){
			String sql = "select employee_id, last_name||first_name as \"name\", email, hire_date, salary, job_id from employees";
			connect();
			List<Employee>list = new ArrayList<>();
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("name"));
//					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setHireDate(rs.getDate("hire_date"));
					emp.setSalary(rs.getInt("salary"));
					emp.setJobId(rs.getString("job_id"));
					
					list.add(emp);
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return list;
		}
}
