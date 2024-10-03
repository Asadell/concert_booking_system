package bookingsystem;

public class Customer extends Person{
	int customerId;

	public Customer(int customerId, String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}
}