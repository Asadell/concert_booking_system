package bookingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.temporal.ChronoUnit;

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
		Locale locale = Locale.forLanguageTag("id-ID");
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy 'jam' HH.mm", locale);
		String formattedDate = date.format(formatDate);

		System.out.println("Concert ID\t: " + concertId);
		System.out.println("Name\t\t: " + name);
		System.out.println("Date\t\t: " + formattedDate);
		System.out.println("Location\t: " + location);
		System.out.println("Ticket Price\t: Rp " + ticketPrice);
		System.out.println("Total Seats\t: " + totalSeats);
		System.out.println("Available Seats\t: " + availableSeats);
		System.out.println("");
	}

	public boolean bookSeat(int numberOfSeats) {
		if(numberOfSeats <= availableSeats) {
			availableSeats -= numberOfSeats;
			return true;
		}
	
		return false;
	}

	public boolean cancelSeat(int numberOfSeats) {
		LocalDateTime now = LocalDateTime.now();
		long daysBetween = ChronoUnit.DAYS.between(now, date);

		if (daysBetween > 7) {
        		availableSeats += numberOfSeats;

			return true;
		}
		
		return false;
	}

	public float getTicketPrice() {
		return ticketPrice;
	}

	public String getName() {
		return name;
	}
}
