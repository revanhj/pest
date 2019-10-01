package com.mytaskImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mytaskBean.Employee;
import com.mytaskDBUtil.DBUtil;

public class EmpleInsert {
	
	public static final String INSERT="INSERT INTO `ragistration`(`empName`,` dateOfBirth`,`email`,`password`) VALUES(?,?,?,?)";
	public Map<String,Object> register(Employee e) throws SQLException
	{
		
		Connection con=DBUtil.getConnection();
		Map<String, Object> map=new HashMap<>();
		try {
			StringBuffer sb=new StringBuffer();
			sb.append("@gmail.com");
			PreparedStatement ps=con.prepareStatement(INSERT);
			ps.setString(1, e.getEmpName());
			ps.setString(2, e.getDateOfBirth());
			ps.setString(3, e.getEmail()+sb);
			ps.setString(4, e.getPassword());
			int i=ps.executeUpdate();
			if(i>0)
			{
				map.put("data","inserted successfull");
				return map;
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
			map.put("data","not inserted successfull");
			return map;		
 		
		
		
		
	}
	public static void main(String[] args) throws SQLException {
		
		
		EmpleInsert el=new EmpleInsert();

		Employee e=new Employee();
		e.setEmpName("hjjhmm");
		e.setDateOfBirth("14-03-1998");
		e.setEmail("qqqqq1938");
		e.setPassword("bbbbb");
		System.out.println(el.register(e));
	}

}