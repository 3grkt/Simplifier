package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Booking;

public interface MessageService {

	void publish(RabbitTemplate topicTemplate,Booking booking, String key);	

}
