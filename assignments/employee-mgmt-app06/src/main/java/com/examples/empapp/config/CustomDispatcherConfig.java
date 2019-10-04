package com.examples.empapp.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.examples.empapp.dao.EmpDao;
import com.examples.empapp.service.EmpService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {
@Bean
public EmpService empService() {
	return new EmpService();
}
@Bean
public EmpDao empDao() {
	return new EmpDao();
}

@Bean
public Connection connect() {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database icredentials
	final String USER = "training";
	final String PASS = "training";

	Connection conn=null;
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
}
