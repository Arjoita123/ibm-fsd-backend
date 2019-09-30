package empManagemnt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpService {
private Employee employee;
EmpDao db_Service = new EmpDao();
	
	public EmpService()
	{
		
	}

/*	public Customer(Person person) {
		this.person = person;
	}*/

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	
	
	public void addNewEmp(Employee e) throws SQLException {
		
		int id = e.getEmpId();
		System.out.println(id);
		int age = e.getAge();
		System.out.println(age);
		String name = e.getName();
		System.out.println(name);
		String department = e.getDept();
		System.out.println(department);
		String country=e.getCountry();
		System.out.println(country);
		
	
	db_Service.insertNewEmployee(id,age,name,department,"AD",country);
	}

	

	public void delete(int id) throws SQLException {
		db_Service.deleteEmp(id);// TODO Auto-generated method stub
		
	}
	
	
//	public void viewAllEmployees() {
//		ResultSet rs = db_Service.getAllEmployee();
//		
//		try {
//			while (rs.next()) {
//				// Retrieve by column name
//				int id = rs.getInt("id");
//				int age = rs.getInt("age");
//				String name = rs.getString("name");
//				String designation = rs.getString("designation");
//				String department = rs.getString("department");
//				String country = rs.getString("country");
//
//				// Display values
//				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
