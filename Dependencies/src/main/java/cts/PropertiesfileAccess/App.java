package cts.PropertiesfileAccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cts/PropertiesfileAccess/config.xml");
		Client sc1 = (Client) ctx.getBean("client");
		System.out.println(sc1);

	}
}
