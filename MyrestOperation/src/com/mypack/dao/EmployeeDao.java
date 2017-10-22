package com.mypack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import com.mypack.DB.Dbconnection;
import com.mypack.model.Employee;

public class EmployeeDao {
	public static final String ADD_EMP = "insert into emp(id,name,age) values(?,?,?)";
	private static final String GET_TOTAL_EMP_NO = "select max(id) from emp";
	private static final String DELETE_EMP = "delete from emp where id=?";
	private static final String GET_EMP = "select *from emp where id=?";
	private static final String UPDATE_EMP = "update emp set name=?,age=? where id=?";
	private static final String GET_ALLEMP = "select *from emp";
	private final static Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public Employee insertEmployee(Employee e) throws ClassNotFoundException, SQLException {
		LOGGER.info("insert called");

		con = Dbconnection.getConnection();
		stmt = con.prepareStatement(GET_TOTAL_EMP_NO);
		stmt.execute();
		rs = stmt.getResultSet();
		rs.next();
		
		stmt.close();
		rs.close();
		stmt = con.prepareStatement(ADD_EMP);
		stmt.setInt(1, e.getId());
		stmt.setString(2, e.getName());
		stmt.setString(3, e.getAge());
		stmt.executeUpdate();
		return e;

	}

	public String deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		LOGGER.info("delete called");
		con = Dbconnection.getConnection();
		stmt = con.prepareStatement(DELETE_EMP);
		stmt.setInt(1, id);
		stmt.execute();
		return "Successfully Deleted";
	}

	public List<Employee> getAllEmployee() throws ClassNotFoundException, SQLException {
		LOGGER.info("get called");
		List<Employee> list = new ArrayList<>();
		Employee e = null;
		con = Dbconnection.getConnection();
		stmt = con.prepareStatement(GET_ALLEMP);
		rs = stmt.executeQuery();
		while(rs.next()) {
			e=new Employee();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setAge(rs.getString("age"));
			list.add(e);
		}
		return list;

	}
	
	public Employee getEmployeeById(int id) throws ClassNotFoundException, SQLException {
		LOGGER.info("get by id called");
		Employee emp=null;
		con = Dbconnection.getConnection();
		stmt = con.prepareStatement(GET_EMP);
		stmt.setInt(1,id);
		rs = stmt.executeQuery();
		if(rs.next()) {
		    emp=new Employee();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getString("age"));
		}
		return emp;
	}
	
	public Employee updateEmployee(Employee emp) throws ClassNotFoundException, SQLException {
		LOGGER.info("update employee called...");
		    con = Dbconnection.getConnection();
			stmt = con.prepareStatement(UPDATE_EMP);						
			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getAge());
			stmt.setInt(3, emp.getId());
			stmt.execute();
			return emp;

}
}