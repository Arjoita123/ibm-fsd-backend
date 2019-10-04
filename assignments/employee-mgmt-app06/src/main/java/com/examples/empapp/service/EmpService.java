package com.examples.empapp.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.dao.EmpDao;
import com.examples.empapp.model.Employee;

public class EmpService {
@Autowired
EmpDao empDao;

List<Employee> list=new ArrayList<Employee>();
	
	public EmpService()
	{
		
	}

/*	public Customer(Person person) {
		this.person = person;
	}*/

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee=employee;
//	}
	
	
	public void addNewEmp(Employee e) throws Exception {
		
//		int id = e.getEmpId();
//		System.out.println(id);
//		int age = e.getAge();
//		System.out.println(age);
//		String name = e.getName();
//		System.out.println(name);
//		String department = e.getDept();
//		System.out.println(department);
		String country=e.getCountry();
	System.out.println(country);
		
	
 empDao.insertNewEmployee(e);
	}

	

	public void delete(int id) throws SQLException {
		empDao.deleteEmp(id);// TODO Auto-generated method stub
		
	}
	
	public List<Employee> viewAllEmployees() throws SQLException {

		return empDao.getAllEmployee();
	}

	
	
	

}
