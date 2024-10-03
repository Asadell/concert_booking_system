import java.time.LocalDateTime;
import bookingsystem.*;

public class Main {
	public static void main(String[] args) {
        	// Instance Concert
        	LocalDateTime concertDate1 = LocalDateTime.of(2024, 10, 9, 19, 0); // 9 Okt 2024 at 19:00
		Concert concert1 = new Concert(101, "Live Music Festival", concertDate1, "Jakarta", 500000, 10); 
        	LocalDateTime concertDate2 = LocalDateTime.of(2024, 10, 15, 16, 0); // 15 Okt 2024 at 16:00
        	Concert concert2 = new Concert(102, "Indie Band Night", concertDate2, "Bandung", 300000, 5);

		System.out.println("\n== Detail Konser ==");
		concert1.getConcertDetails();
		concert2.getConcertDetails();

		// Instance Staff
		Staff staff1 = new Staff(201, "John Davis", "johndavis@gmail.com", "081253455432", "Event Manager");
		staff1.assignConcert(concert1, "Mengatur panggung dan audio");
		staff1.assignConcert(concert2, "Mengelola tiket dan keamanan");
		staff1.displayAssignments();

		// Instance Customer
		Customer customer = new Customer(301, "Asadel", "asadel@gmail.com", "081098765432");
		System.out.println("\n== Detail Customer ==");
		customer.getDetails();

		
	}
}
