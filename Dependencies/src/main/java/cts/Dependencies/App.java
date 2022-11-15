package cts.Dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cts/Dependencies/config.xml");
		ShoppingCart sc1 = (ShoppingCart) ctx.getBean("Shoppingcart1");
		System.out.println(sc1.getItem());

		ShoppingCart sc2 = (ShoppingCart) ctx.getBean("Shoppingcart2");
		System.out.println(sc2.getItem());
		ShoppingCart sc3 = (ShoppingCart) ctx.getBean("Shoppingcart3");
		System.out.println(sc3.getItem());

	}
}
