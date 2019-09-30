package empManagemnt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpConfig {
//	(initMethod="init")
	    @Bean
	    public EmpService empService() {
	    	EmpService empService = new EmpService();	// constructor injection
	        // setter injection
//	        EmpService.setEmployee(employee());
	    	empService.setEmployee(employee());
	        return empService;
	    }
	    
	    @Bean
	    public Employee employee() {
	        return new Employee(100,22,"AKASH","IT","INDIA");
	    }
	    @Bean
		public EmpDao empDao() {
			return new EmpDao();
		}

}
