package empManagemnt;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class EmpDao {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database icredentials
	final String USER = "training";
	final String PASS = "training";
	
	static Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connection connect() {

		try {
			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			//System.out.println("Creating statement...");
		}catch (Exception e) {

		}
		return conn;
	}
	
	
	public void insertNewEmployee(int id, int age, String name, String department, String designation, String country) throws SQLException {
		System.out.println(id);
		
		
		String insertQuery = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(insertQuery);
		pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, "Lead");
			pstmt.setString(4, department);
			pstmt.setString(5, country);
			int insertCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(insertCount + " Employee(s) inserted");
		
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
	
	public void getAllEmployee() throws SQLException {
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

//		java.sql.Statement stmt = null;
//		ResultSet rs = null;
//
//		try {
//			stmt =  conn.createStatement();
//			String selectQuery = "select * from employees";
//			rs = stmt.executeQuery(selectQuery);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
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
