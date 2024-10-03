package bookingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concert {
	private int concertId;
	private String name;
	private LocalDateTime date;
	private String location;
	private float ticketPrice;
	private int totalSeats;
	private int availableSeats;

	public Concert(int concertId, String name, LocalDateTime date, String location, float ticketPrice, int totalSeats) {
		this.concertId = concertId;
		this.name = name;
		this.date = date;
		this.location = location;
		this.ticketPrice = ticketPrice;
		this.totalSeats = totalSeats;
		this.availableSeats = totalSeats;
	}

	public void getConcertDetails() {
		DateTimeFormatter formatDate = DateTimeFormatter("EEEE, d MMMM yyyy 'jam' HH.mm", new Locale("id", "ID"));
		String formattedDate = date.format(formatDate);

		System.out.println("Concert ID: " + concertId);
		System.out.println("Name: " + name);
		System.out.println("Date: " + formattedDate);
		System.out.println("Location: " + location);
		System.out.println("Ticket Price: $" + ticketPrice);
		System.out.println("Total Seats: " + totalSeats);
		System.out.println("Available Seats: " + availableSeats);
	}

	public boolean bookSeat(int numberOfSeats) {
		if(numberOfSeats <= availableSeats) {
			availableSeats -= numberOfSeats;
			return true;
		}
	
		return false;
			//System.out.println(numberOfSeats + " seats booked successfully.");
        	//} else {
        		//System.out.println("Not enough available seats.");
        	//}
	}

	public void cancelSeat(int numberOfSeats) {
        	availableSeats += numberOfSeats;
        	System.out.println(numberOfSeats + " seats canceled successfully.");
	}

	public float getTicketPrice() {
		return ticketPrice;
	}
}
