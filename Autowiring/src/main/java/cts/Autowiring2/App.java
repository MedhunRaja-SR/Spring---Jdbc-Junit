package cts.Autowiring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("cts/Autowiring2/config.xml");
		Customer sc1 = (Customer) ctx.getBean("customer");
		System.out.println(sc1);
	}
}
