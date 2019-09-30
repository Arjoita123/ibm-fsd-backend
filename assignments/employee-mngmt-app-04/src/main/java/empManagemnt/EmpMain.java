package empManagemnt;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmpMain {
	public static void main(String[] args) throws SQLException {
		// Assemble the objects
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);

		EmpService obj = (EmpService) context.getBean("empService");
		EmpDao emp = (EmpDao) context.getBean("empDao");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.ADD"+" "+"2.VEIW"+" "+"3.DELETE");
		int i=sc.nextInt();
		if(i==1) {
//			Employee e = getInput();
			System.out.println("Enter Name");
			String nName=sc.next();
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter Age");
			int nAge=sc.nextInt();
			System.out.println("Enter Designation");
			String nDesign=sc.next();
			System.out.println("Enter Department");
			String nDept=sc.next();
			System.out.println("Enter Country");
			String nCountry=sc.next();
			Employee newEmp = new Employee(id,nAge,nName,   nDept, nCountry);
			EmpDao.conn= emp.connect();
			obj.addNewEmp(newEmp);
		}
		if(i==2) {
//			obj.viewAllEmployees();
			emp.getAllEmployee();
		}
		
		if(i==3) {
			int id=sc.nextInt();
			EmpDao.conn= emp.connect();
			obj.delete(id);
		}


		
		
		
		
		
		
//		System.out.println("Employee: " + obj);
//		System.out.println("Dependent Person: " + obj.getEmployee());
//		
//		Employee obj1 = (Employee) context.getBean("employee");
//		System.out.println("Person: " + obj1);
//
//		System.out.println(
//				obj.getEmployee().getName() + " " + obj.getEmployee().getAge() );
//
//		context.registerShutdownHook();	

	
	}
//
//	private static Employee getInput() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static void getData() {
//		// TODO Auto-generated method stub
//		
//	}
}