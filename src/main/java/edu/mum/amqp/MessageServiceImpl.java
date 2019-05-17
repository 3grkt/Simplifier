package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import edu.mum.domain.Booking;
@Service
public class MessageServiceImpl implements MessageService {

 	public void publish(RabbitTemplate rabbitTemplate, Booking booking, String key) {
 	   	 
        rabbitTemplate.convertAndSend(key, booking);
 
    }

}
