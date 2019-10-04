package com.examples.empapp.controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.empapp.dao.EmpDao;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmpService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmpService empService;
	
	
	
	@GetMapping
	public List<Employee> getAllEmployees() throws SQLException {
		
	
		
		return empService.viewAllEmployees();
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String createEmployee(@RequestBody Employee employee) throws Exception {
		empService.addNewEmp(employee);
		return "Employee created successfully";
	}

}
