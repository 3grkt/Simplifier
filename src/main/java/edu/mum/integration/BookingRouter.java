
package edu.mum.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import edu.mum.domain.Booking;
import edu.mum.domain.Room;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class BookingRouter {

    final Logger logger = LoggerFactory.getLogger(BookingRouter.class);
    
    /**
     * Process order.  Routes based on whether or 
     * not the order is a delivery or pickup.
     */
	@Router(inputChannel="fromAmqpBooking")
	public String fromAmqpBooking(Booking booking) {
		
	    String destination = null;
	    int capacity = 0;
	    for (Room room:booking.getRooms()){
	    	capacity += room.getCapacity();
	    }
	    if (capacity > 10){
	    	destination = "supervisorBooking";
	    }
	    else
	    	destination = "adminBooking";
  	    
	
		return destination;
	}

}
