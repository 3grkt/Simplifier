package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Booking;
import edu.mum.domain.BookingStatus;

public interface BookingDao extends GenericDao<Booking> {
	public List<Booking> findBookingByStatus(int bookingStatus);
 	}
