package springAssignments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration

public class EmployeeConfig {
	 @Bean
	    public Employee employee() {
	        return new Employee(address());
	    }
	    
	    @Bean
	    public Address address() {
	        return new Address("R.N TAGORE STREET",700077,"KOLKATA","INDIA");
	    }
}
