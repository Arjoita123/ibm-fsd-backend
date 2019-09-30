package springAssignments;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springAssignments.*;

public class EmployeeMain {
	

	
		public static void main(String[] args) {
			// Assemble the objects
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);

			Employee obj = (Employee) context.getBean("employee");
			
			System.out.println("Emp id"+" "+obj.getId());
			System.out.println("Emp name"+" "+obj.getName());
			System.out.println("Emp joining date"+" "+obj.getJd());
			System.out.println("Emp active"+" "+obj.getActive());
			System.out.println(
					"Address:"+" "+obj.getAddress().getStreet() + " " + obj.getAddress().getCity() + " " + obj.getAddress().getCountry());
			

			context.registerShutdownHook();		
		

	}
}
