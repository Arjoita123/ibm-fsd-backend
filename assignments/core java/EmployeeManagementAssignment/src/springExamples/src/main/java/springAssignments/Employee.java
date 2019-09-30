package springAssignments;

public class Employee {
	int id=100;
	String name="Arjoita";
	String jd="12th July 2019";
	Boolean active=true;
	Address address;
	public Employee()
	{
		
	}

	public Employee(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getJd() {
		return jd;
	}
	public boolean getActive() {
		return active;
	}

}
