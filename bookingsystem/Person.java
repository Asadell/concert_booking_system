package bookingsystem;

public class Person {
	private String name;
	private String email;
	private String phoneNumber;

	public Person(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void getDetails() {
		System.out.println("Nama\t: " + name);
		System.out.println("Email\t: " + email);
		System.out.println("No hp\t: " + phoneNumber);
	}

	public void updateContactInfo(String email, String phoneNumber) {
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}