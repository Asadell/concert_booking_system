package bookingsystem;

import bookingsystem.Customer;
import bookingsystem.Concert;

public class Booking {
	private int bookingId;
	private Customer customer;
	private Concert concert;
	private int bookedSeats;
	private float totalPrice;
	private enum Status {PENDING, CONFIRMED, COMPLETED, CANCELLED};
	private Status statusBooking;


	public Booking(int bookingId, Customer customer, Concert concert) {
		this.bookingId = bookingId; 
		this.customer = customer; 
		this.concert = concert; 
		this.bookedSeats = 0; 
		this.totalPrice = 0; 
		this.statusBooking = Status.PENDING;
	}

	private void calculateTotalPrice() {
		totalPrice = (float) (bookedSeats * concert.getTicketPrice() * 1.1); // pajak 10%
	}

	public float getTotalPrice() {
		if (statusBooking == Status.PENDING) {
			System.out.println("Your booking is not yet confirmed. Please complete the process.");
		}

		return totalPrice;
	}

	public void confirmBooking(int numberOfSeats) {
		if (concert.bookSeat(numberOfSeats)) {
			bookedSeats = numberOfSeats;
			statusBooking = Status.CONFIRMED;
			calculateTotalPrice();
			System.out.println(numberOfSeats + " seats booked successfully.");

			return;
		}

		System.out.println("Cannot cancel more seats than booked.");
	}

	public void cancelBooking() {
		if (statusBooking != Status.CONFIRMED) {
			System.out.println("You cannot cancel this booking as it has not been confirmed.");
			return;
		}

		if (concert.cancelSeat(bookedSeats)) {
			statusBooking = Status.CANCELLED;
			System.out.println("Your booking has been successfully cancelled.");
		}
		
        	System.out.println("The concert is less than 7 days away. You cannot cancel your booking.");
	}

	public void invoice() {
		System.out.println("ya");
	}

}
