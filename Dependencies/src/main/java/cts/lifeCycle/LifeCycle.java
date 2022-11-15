package cts.lifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycle {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("cts/lifeCycle/config.xml");
		TicketReservation sc1 = (TicketReservation) ctx.getBean("TR");
		System.out.println(sc1);
		ctx.registerShutdownHook();
		
	}

}
