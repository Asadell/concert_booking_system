package bookingsystem;

import bookingsystem.Customer;
import bookingsystem.Concert;

public class Booking {
	private int bookingId;
	private Customer customer;
	private Concert concert;
	//private int numberOfSeats;
	private float totalPrice;
	private enum Status {PENDING, CONFIRMED, COMPLETED, CANCELLED};
	private Status statusBooking;


	public Booking(int bookingId, Customer customer, Concert concert) {
		this.bookingId = bookingId; 
		this.customer = customer; 
		this.concert = concert; 
		this.numberOfSeats = 0; 
		this.totalPrice = 0; 
		this.statusBooking = enumStatus.PENDING;
	}

	private void calculateTotalPrice(int numberOfSeats) {
		totalPrice = numberOfSeats * concert.getTicketPrice() * 1.1; // pajak 10%
	}

	public float getTotalPrice() {
		if (statusBooking == Status.PENDING) {
			System.out.println("Booking blum beres");
		}

		return totalPrice;
	}

	public void confirmBooking(int numberOfSeats) {
		if (concert.bookSeat(numberOfSeats)) {
			System.out.println(numberOfSeats + " seats booked successfully.");
			statusBooking = Status.CONFIRMED;

			return;
		}

		System.out.println("Cannot cancel more seats than booked.");
	}

	public void invoice() {
		System.out.println("ya");
	}

}
