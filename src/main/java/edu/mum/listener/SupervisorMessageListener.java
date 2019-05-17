package edu.mum.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.domain.Booking;


public class SupervisorMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(SupervisorMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Booking bookRouteOrder = null;
		try {
			bookRouteOrder = (Booking) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String memberInfo = bookRouteOrder.getUser().getFirstName() + " " + bookRouteOrder.getUser().getLastName() + " on " + bookRouteOrder.getBookingDate();
        System.out.println("Supervisor - Message received for booking over capacity of 10: " );
        System.out.println(memberInfo + "  has send a booking request." );

    }
}
