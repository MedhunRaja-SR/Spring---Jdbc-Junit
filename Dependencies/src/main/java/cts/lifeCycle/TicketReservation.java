package cts.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TicketReservation {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("Inside Setter() Method");
		this.id = id;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Inside Init() Method");
	}
	
	@PreDestroy
	public void bye() {
		System.out.println("Inside destroy() Method");
	}
	
	@Override
	public String toString() {
		return "TicketReservation [id=" + id + "]";
	}
	
	
}
