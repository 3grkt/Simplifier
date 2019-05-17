package edu.mum.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.Booking;

public class BookingListener {
	private final String SENDER_XML = "classpath:META-INF/spring/amqp-rabbit-sender.xml";
	// Listens on the "directQueue" associated with the "direct" exchange
	public void listen(Booking booking) {
		try {
			String memberInfo = booking.getUser().getFirstName() + " " + booking.getUser().getLastName() + " on " + booking.getBookingDate();
		     System.out.println("================ Message received=================");
			System.out.println("Booking for: " + memberInfo + " is approved.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}