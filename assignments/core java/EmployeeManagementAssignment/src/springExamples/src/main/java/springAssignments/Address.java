package springAssignments;

public class Address {
	String street;
	
	String city;
	String country;
	int pin;

	public Address() {

	}

	public Address(String street, int pin, String city,String country) {
		this.street = street;
		this.pin = pin;
		this.city = city;
		this.country=country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
