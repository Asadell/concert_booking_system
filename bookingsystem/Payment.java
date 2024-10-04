package bookingsystem;

import java.time.LocalDateTime;
import java.util.AbstractMap.SimpleEntry;
import bookingsystem.Booking;

public class Payment {
	private int paymentId;
	private Booking booking;
	private LocalDateTime paymentDate;
	private SimpleEntry<String, Integer> paymentMethodEntry;
	private enum Status {PENDING, COMPLETED, FAILED, CANCELLED};
	private Status paymentStatus;
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";

	public Payment(int paymentId, Booking booking, String paymentMethod, int saldo) {
		this.paymentId = paymentId;
		this.booking = booking;
		this.paymentDate = LocalDateTime.now();
		this.paymentMethodEntry = new SimpleEntry<>(paymentMethod, saldo);
		this.paymentStatus = Status.PENDING;
	}

	public void processPayment() {
		if (paymentStatus != Status.PENDING) {
			System.out.println("Please make a new payment.");

			return;
		}

		if (booking.getTotalPrice() > paymentMethodEntry.getValue()) {
			if (booking.getTotalPrice() == 0) return;

			System.out.println(ANSI_RED + "Your " + paymentMethodEntry.getKey() + " balance is not enough. Please use another payment method." + ANSI_RESET);
			paymentStatus = Status.FAILED;

			return;
		} 

		//booking.setStatusToCompleted();
		paymentStatus = Status.COMPLETED;
		System.out.println(ANSI_GREEN + "Payment successful with paymentId #" + paymentId + ANSI_RESET);
	}

	public void refundPayment() {
		System.out.println("Your payment has been canceled.");
		paymentStatus = Status.CANCELLED;
	}
}
