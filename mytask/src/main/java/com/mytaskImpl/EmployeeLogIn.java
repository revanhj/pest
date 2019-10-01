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

 
 
public class EmployeeLogIn {
	
	public static String Fetch="SELECT * FROM `ragistration` where `email`= ? AND `password`=? ";
	
	public Object logIn(Employee c) throws SQLException, ParseException 
	{
	Map<String,Object> map=new HashMap<>();

	Connection con=DBUtil.getConnection();

		PreparedStatement ps=con.prepareStatement(Fetch);
		ps.setString(1, c.getEmail());
		ps.setString(2, c.getPassword());
		ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("count")>3)
				map.put("msg", "login succussfully");
				map.put("status", "0");
				return map;
				
			}else {
				
				map.put("msg", "not login succussfully");
				map.put("status", "0");
				return map;
			}

	}
	
	
	public static void main(String[] args) throws SQLException, ParseException {
		
		Employee e=new Employee();
		e.setEmail("revanhj1993@gmail.com");
		e.setPassword("qwerty");
		EmployeeLogIn v=new EmployeeLogIn();
		System.out.println(v.logIn(e));
		
	}

}
