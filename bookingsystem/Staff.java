package bookingsystem;

import java.util.HashMap;
import java.util.Map;
import bookingsystem.Concert;


public class Staff extends Person{
	private int staffId;
	private String position;
	private HashMap<Concert, String> concertAssignments;

	public Staff(int staffId, String name, String email, String phoneNumber, String position) {
		super(name, email, phoneNumber);
		this.staffId = staffId;
		this.position = position;
		this.concertAssignments = new HashMap<>();
	}

	public void assignConcert(Concert concert, String jobDesc) {
		concertAssignments.put(concert, jobDesc);
	}

	public void displayAssignments() {
		System.out.printf("\n=== Tugas Staff '%s' #%s ===\n", getName(), staffId);
		
		for (Map.Entry<Concert, String> entry : concertAssignments.entrySet()) {
			Concert concert = entry.getKey();
			String jobDesc = entry.getValue();
			
			System.out.println("Konser\t\t\t: " + concert.getName());
			System.out.println("Deskripsi Pekerjaan\t: " + jobDesc);
			System.out.println("");
		}
	}
}