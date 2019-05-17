package edu.mum.service;

import java.util.List;

import edu.mum.domain.Booking;


public interface BookingService {

	public List<Booking> findAll();
 	public Booking findOne(Long id);
 	public List<Booking> findBookingsByStatus(int bookingStatus);
 	public void save(Booking booking);
 	public void saveFull(Booking booking);
 	public void update(Booking booking);
 	
 	public void processBooking(Booking booking, int bookingStatus);
}
