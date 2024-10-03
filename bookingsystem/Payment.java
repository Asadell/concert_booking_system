package bookingsystem;

import java.time.LocalDateTime;
import java.util.AbstractMap.SimpleEntry;
import bookingsystem.Booking;

public class Payment {
	private int paymentId;
	private Booking booking;
	private float amount;
	private LocalDateTime paymentDate;
	private SimpleEntry<String, Integer> paymentMethodEntry;
	private enum Status {PENDING, COMPLETED, FAILED, CANCELLED};
	private Status paymentStatus;


	public Payment(int paymentId, Booking booking, float amount, LocalDateTime paymentDate, String paymentMethod, int saldo) {
		this.paymentId = paymentId;
		this.booking = booking;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethodEntry = new SimpleEntry<>(paymentMethod, saldo);
		this.paymentStatus = Status.PENDING;
	}

	public void processPayment() {
		if (!paymentStatus.equals(Status.PENDING)) {
			System.out.println("Please make a new payment.");

			return;
		}

		if (booking.getTotalPrice() > paymentMethodEntry.getValue()) {
			if (booking.getTotalPrice() == 0) return;

			System.out.println("Your balance is insufficient. Please use another payment method.");
			paymentStatus = Status.FAILED;

			return;
		} 

		System.out.println("Payment successful with paymentId #" + paymentId);
		paymentStatus = Status.COMPLETED;
	}

	public void refundPayment() {
		System.out.println("Your payment has been canceled.");
		paymentStatus = Status.CANCELLED;
	}
}
