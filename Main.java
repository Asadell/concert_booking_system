import java.time.LocalDateTime;
import bookingsystem.*;

public class Main {
	public static void main(String[] args) {
        	// Instance Concert
        	LocalDateTime concertDate1 = LocalDateTime.of(2024, 10, 6, 19, 0);
		Concert concert1 = new Concert(101, "Live Music Festival", concertDate1, "Jakarta", 500_000, 5); 
        	LocalDateTime concertDate2 = LocalDateTime.of(2024, 10, 12, 16, 0);
        	Concert concert2 = new Concert(102, "Indie Band Night", concertDate2, "Bandung", 300_000, 10);

		System.out.println("\n== Detail Konser ==");
		concert1.getConcertDetails();
		concert2.getConcertDetails();

		// Instance Staff
		Staff staff1 = new Staff(201, "John Davis", "johndavis@gmail.com", "081253455432", "Event Manager");
		staff1.assignConcert(concert1, "Mengatur panggung dan audio");
		staff1.assignConcert(concert2, "Mengelola tiket dan keamanan");
		staff1.displayAssignments();

		// Instance Customer
		Customer customer1 = new Customer(301, "Asadel", "asadel@gmail.com", "081098765432");
		Customer customer2 = new Customer(302, "Satrio", "satrio@gmail.com", "081732498352");
		System.out.println("\n== Detail Customer ==");
		customer1.getDetails();

		// Instace Booking
		System.out.println("\nMembuat booking untuk customer Asadel dan Satrio");
		Booking booking1 = new Booking(401, customer1, concert1);
		Booking booking2 = new Booking(402, customer2, concert1);
		Booking booking3 = new Booking(403, customer1, concert2);
		
		// CASE 1 (Asadel failed to cancel)
		System.out.println("\nAsadel mencoba membatalkan booking 'Live Music Festival'");
		booking1.cancelBooking();

		System.out.println("\nAsadel mencoba booking 4 kursi untuk 'Live Music Festival'");
		booking1.confirmBooking(4);
		System.out.println("\nAsadel mencoba booking 2 kursi untuk 'Indie Band Night'");
		booking3.confirmBooking(2);

		// CASE 2 (Satrio failed to confirm)
		System.out.println("\nSatrio mencoba booking 2 kursi untuk 'Live Music Festival'");
		booking2.confirmBooking(2);

		// Instance payment
		System.out.println("\nMembuat payment untuk booking Asadel dan Satrio");
		Payment payment1 = new Payment(501, booking1, "Shopee Pay", 1_000_000);
		Payment payment2 = new Payment(502, booking1, "GoPay", 2_500_000);
		Payment payment3 = new Payment(503, booking3, "BCA", 1_000_000);

		// CASE 3 (Insuffient balance)
		System.out.println("\nAsadel mencoba melakukan pembayaran dengan Shopee Pay sebesar Rp1.000.000");
		payment1.processPayment();
		// CASE 4 (failed to try again)
		System.out.println("\nAsadel mencoba kembali melakukan pembayaran dengan Shopee Pay");
		payment1.processPayment();

		System.out.println("\nAsadel mencoba melakukan pembayaran dengan GoPay sebesar Rp2.500.000");
		payment2.processPayment();
		System.out.println("\nAsadel mencoba melakukan pembayaran untuk 'Indie Band Night' dengan BCA sebesar Rp1.000.000");
		payment3.processPayment();

		System.out.println("\nAsadel mencoba membatalkan booking 'Indie Band Night'");
		booking3.cancelBooking();

		// CASE 5 (failed cancel booking1)
		System.out.println("\nAsadel mencoba membatalkan booking 'Live Music Festival' yang sudah kurang dari 7 hari");
		booking1.cancelBooking();
		// CASE 6 (failed print invoice (karena CANCEL))
		System.out.println("\nAsadel mencoba print invoice dari book yang sudah dibatalkan");
		booking3.invoice();

		//print innvoice
		booking1.invoice();
	}
}
