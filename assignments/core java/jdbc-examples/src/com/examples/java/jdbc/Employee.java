package com.examples.java.jdbc;

public class Employee {

	int empId;
	int age;
	String name;
	String dept;
	String country;

//	Employee(int empId, int age,String name,	String dept,String country ) {
//		this.empId = empId;
//		this.age = age;
//		this.name = name;
//		this.dept=dept;
//		this.country=country;
//
//	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String a) {
		name = a;
	}
	

	public String getDept() {
		return dept;
	}

	public void setDept(String a) {
		dept = a;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String a) {
		country = a;
	}
	@Override
	public String toString() {
		return " Emloyee[id.=" + empId + "Age: "+age+"Name: "+name+"department: "+dept+"Country: "+country + "]";
	}
}
