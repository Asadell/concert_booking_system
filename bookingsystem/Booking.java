package bookingsystem;

import bookingsystem.Customer;
import bookingsystem.Concert;
import bookingsystem.Payment;

public class Booking {
	private int bookingId;
	private Customer customer;
	private Concert concert;
	private int bookedSeats;
	private float totalPrice;
	private enum Status {PENDING, CONFIRMED, COMPLETED, CANCELLED};
	private Status statusBooking;
	private Payment payment;
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";

	public Booking(int bookingId, Customer customer, Concert concert) {
		this.bookingId = bookingId; 
		this.customer = customer; 
		this.concert = concert; 
		this.bookedSeats = 0; 
		this.totalPrice = 0; 
		this.statusBooking = Status.PENDING;
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
			System.out.println(ANSI_GREEN + numberOfSeats + " seats booked successfully." + ANSI_RESET);

			return;
		}

		System.out.println(ANSI_RED + "The available seats are fewer than your request." + ANSI_RESET);
	}

	public void cancelBooking() {
		if (statusBooking != Status.CONFIRMED) {
			System.out.println(ANSI_RED + "You cannot cancel this booking as it has not been confirmed." + ANSI_RESET);

			return;
		}

		if (concert.cancelSeat(bookedSeats)) {
			payment.refundPayment();
			statusBooking = Status.CANCELLED;
			System.out.println(ANSI_GREEN + "Your booking has been successfully cancelled." + ANSI_RESET);

			return;
		}
		
        	System.out.println(ANSI_RED + "The concert is less than 7 days away. You cannot cancel your booking." + ANSI_RESET);
	}

	public void setStatusToCompleted() {
		statusBooking = Status.COMPLETED;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void invoice() {
		if (statusBooking == Status.CANCELLED) {
			System.out.println(ANSI_RED + "Cannot print invoice, your booking has been cancelled" + ANSI_RESET);

			return;
		}

		System.out.println("\n=============== INVOICE ===============");
		System.out.println("Booking ID\t: " + bookingId);
		System.out.println("Customer Name\t: " + customer.getName());
		System.out.println("Customer Email\t: " + customer.getEmail());
		System.out.println("Concert Name\t: " + concert.getName());
		System.out.println("Seats Booked\t: " + bookedSeats);
		System.out.printf("Ticket Price\t: Rp %.2f%n", concert.getTicketPrice());
		System.out.printf("Total Price\t: Rp %.2f (incl. tax)%n", totalPrice);
		System.out.println("Booking Status\t: " + statusBooking);
		System.out.println("========================================");
	}

	private void calculateTotalPrice() {
		totalPrice = (float) (bookedSeats * concert.getTicketPrice() * 1.1); // pajak 10%
	}

}
