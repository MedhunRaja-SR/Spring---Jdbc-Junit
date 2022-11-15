package cts.Autowiring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {

	@Autowired(required=false)
	@Qualifier("reservation2")
	private Reservation reservation;

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	public Customer(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Customer [reservation=" + reservation + "]";
	}
	
}
