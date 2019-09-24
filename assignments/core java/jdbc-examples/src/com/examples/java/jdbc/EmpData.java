package com.examples.java.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.mysql.jdbc.Connection;

public class EmpData {
	
	
	
	
	
	


	public void display() throws Exception {

		
		Employee emp=new Employee();
		System.out.println("Enter id");
		Scanner sc1=new Scanner(System.in);
		int i=sc1.nextInt();
		

		System.out.println("Enter age");
		Scanner sc2=new Scanner(System.in);
		int a=sc2.nextInt();
		
		System.out.println("Enter name");
		Scanner sc3=new Scanner(System.in);
		 String n=sc3.next();
		
		System.out.println("Enter department");
		Scanner sc4=new Scanner(System.in);
		 String d=sc4.next();
		
		System.out.println("Enter country");
		Scanner sc5=new Scanner(System.in);
		 String c=sc5.next();
		emp.setAge(a);
		emp.setEmpId(i);
		emp.setDept(d);
		emp.setName(n);
		emp.setCountry(c);
		


		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

		// Database icredentials
		final String USER = "training";
		final String PASS = "training";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
		

			// Insertion with Statement
			String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
		pstmt.setString(1, n);
			pstmt.setInt(2, a);
			pstmt.setString(3, "Lead");
			pstmt.setString(4, d);
			pstmt.setString(5, c);
			int insertCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(insertCount + " Employee(s) inserted");
	}
	
 public void veiwAll() throws Exception {
	 Class.forName("com.mysql.jdbc.Driver");  
   
////Creating and Executing RowSet  
	  JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
	     rowSet.setUrl("jdbc:mysql://localhost:3306/jdbctraining");  
       rowSet.setUsername("training");  
       rowSet.setPassword("training"); 

   
   
              
   rowSet.setCommand("SELECT * FROM employee");  
  rowSet.execute();  
            
while (rowSet.next()) {  
                  // Generating cursor Moved event  
                  System.out.println("Id: " + rowSet.getString(1));  
                 System.out.println("Name: " + rowSet.getString(2));  
                  System.out.println("age: " + rowSet.getString(3));  
           }
	 
 }
 
 
 public void update()throws Exception{
	 
	 Employee emp=new Employee();
		System.out.println("Enter id of the employee to be updated");
		Scanner sc1=new Scanner(System.in);
		int i=sc1.nextInt();
		

		
		
		System.out.println("Enter name to be updated");
		Scanner sc3=new Scanner(System.in);
		 String n=sc3.next();

		
	
		emp.setEmpId(i);
	
		emp.setName(n);

		
		
		
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

		// Database icredentials
		final String USER = "training";
		final String PASS = "training";
		
		Connection conn = null;
		Statement stmt = null;
//		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		Class.forName("com.mysql.jdbc.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		conn.setAutoCommit(true); // enable transaction

		System.out.println("Connection estabilished: " + conn);

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement("update employee set name=? where id=?");
		pstmt.setString(1, n);
		pstmt.setInt(2, i);
		 
		  
		int x=pstmt.executeUpdate();  
		System.out.println(i+" records updated"); 
		
		
		
	 
 }
 
 void delete() throws Exception {
	 
	 Employee emp=new Employee();
		System.out.println("Enter id of the employee to be deleted");
		Scanner sc1=new Scanner(System.in);
		int i=sc1.nextInt();
		
	 
	 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

		// Database icredentials
		final String USER = "training";
		final String PASS = "training";
		
		Connection conn = null;
		Statement stmt = null;
//		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		Class.forName("com.mysql.jdbc.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		conn.setAutoCommit(true); // enable transaction

		System.out.println("Connection estabilished: " + conn);

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
	 
	 PreparedStatement pstmt=conn.prepareStatement("delete from employee where id=?");  
	 pstmt.setInt(1,i);  
	   
		int x=pstmt.executeUpdate();  
	 System.out.println(i+" records deleted"); 
 }
 
 void veiw() throws Exception {
	 Employee emp=new Employee();
		System.out.println("Enter id of the employee to be veiwed");
		Scanner sc1=new Scanner(System.in);
		int i=sc1.nextInt();
		
		

		 Class.forName("com.mysql.jdbc.Driver");  
		   
		////Creating and Executing RowSet  
			  JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
			     rowSet.setUrl("jdbc:mysql://localhost:3306/jdbctraining");  
		       rowSet.setUsername("training");  
		       rowSet.setPassword("training"); 

		   
		   
		              
		   rowSet.setCommand("SELECT * FROM employee WHERE id=14");  
		  rowSet.execute();  
		            
		while (rowSet.next()) {  
		                  // Generating cursor Moved event  
		                  System.out.println("Id: " + rowSet.getString(1));  
		                 System.out.println("Name: " + rowSet.getString(2));  
		                  System.out.println("age: " + rowSet.getString(3));  
		           } 
		   
		              
		  
	 
	 
 }

}
