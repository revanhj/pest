package com.mytaskImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.mytaskBean.Employee;
import com.mytaskDBUtil.DBUtil;

public class EmpLogIn {
	
	public static String INSERT="INSERT INTO `ragistration`(`empName`,`email`,`password`)VALUES(?,?,?);";
	
	public Object logInTask(Employee c) throws SQLException, ParseException 
	{
	Map<String,Object> map=new HashMap<>();
	Connection con=DBUtil.getConnection();
	
		PreparedStatement ps=con.prepareStatement(INSERT);
		ps.setString(1, c.getEmail());
		ps.setString(2, c.getPassword());
		ps.setString(3, c.getEmpName());
		int status=ps.executeUpdate();
			if(status>0) {
				map.put("msg", "login succussfully");
				return map;

				
			}else {
				map.put("msg", "login succussfully");
				return map;
			}
		}
		

	public static void main(String[] args) throws SQLException, ParseException {
		
		Employee e=new Employee();
		e.setEmail("revanhj1993@gmail.com");
		e.setPassword("qwerty");
		e.setEmpName("pramod");
		EmpLogIn v=new EmpLogIn();
		System.out.println(v.logInTask(e));
		
	}

}
