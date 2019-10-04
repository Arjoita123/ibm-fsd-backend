package com.examples.empapp.dao;

import java.beans.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.model.Employee;

public class EmpDao {

	

	
	static Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	
	
	public void insertNewEmployee(Employee employee) throws Exception {
		
		 stmt =  (Statement) conn.createStatement();
		
		
		String query = "INSERT INTO employee(name, age, department, designation, country) values(\""
				+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDept() + "\",\""
				+ "lead"+ "\",\"" + employee.getCountry() + "\")";
			

	

		 ((java.sql.Statement) stmt).executeUpdate(query);
		
		
		
//		String insertQuery = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
//		pstmt = conn.prepareStatement(insertQuery);
//		pstmt.setString(1, e.getName());
//			pstmt.setInt(2, e.getAge());
//			pstmt.setString(3, "Lead");
//			pstmt.setString(4, e.getDept());
//			pstmt.setString(5,e.getCountry());
//			int insertCount = pstmt.executeUpdate();
//			pstmt.close();
//			System.out.println(insertCount + " Employee(s) inserted");
		
//		String insertQuery = "INSERT INTO employees (name, age, department, designation, country) VALUES (?, ?, ?, ?, ?)";
//		try {
//			PreparedStatement ps = conn.prepareStatement(insertQuery);
//			ps.setString(1, name);
//		ps.setInt(2, age);
//		ps.setString(3, designation);
//			ps.setString(4, department);
//			ps.setString(5, country);
//			int i = ps.executeUpdate();
//			ps.close();
//		//System.out.println(i);
//			conn.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> li=new ArrayList<Employee>();
		  JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
		     rowSet.setUrl("jdbc:mysql://localhost:3306/jdbctraining");  
	       rowSet.setUsername("training");  
	       rowSet.setPassword("training"); 

	   
	   
	              
	   rowSet.setCommand("SELECT * FROM employee");  
	  rowSet.execute();  
	            
	while (rowSet.next()) {  
	                  // Generating cursor Moved event
		
		String id=rowSet.getString(1);
		int i=Integer.parseInt(id);
		String name=rowSet.getString(2);
		String age=rowSet.getString(3);
		int a=Integer.parseInt(age);
		String designation=rowSet.getString(4);
		String dept=rowSet.getString(5);
		String country=rowSet.getString(6);
	Employee emp= new Employee(i,a,name,dept,country);
	  
	li.add(emp);
	                  System.out.println("Id: " + rowSet.getString(1));  
	                 System.out.println("Name: " + rowSet.getString(2));  
	                  System.out.println("age: " + rowSet.getString(3));  
	           }
	return li;


	}


	public void deleteEmp(int id) throws SQLException {
		int i=id;
		 
		 PreparedStatement pstmt=conn.prepareStatement("delete from employee where id=?");  
		 pstmt.setInt(1,i);  
		   
			int x=pstmt.executeUpdate();  
		 System.out.println(i+" records deleted"); 
		// TODO Auto-generated method stub
		
	}
		
}
