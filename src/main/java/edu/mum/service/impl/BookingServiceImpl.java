package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.BookingDao;
import edu.mum.dao.RoomDao;
import edu.mum.domain.Booking;
import edu.mum.domain.Room;
import edu.mum.service.BookingService;
import edu.mum.service.RoomService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private RoomDao roomDao;

	public List<Booking> findAll() {
		return (List<Booking>) bookingDao.findAll();
	}

	public List<Booking> findBookingsByStatus(int bookingStatus) {

		return (List<Booking>) bookingDao.findBookingByStatus(bookingStatus);
	}

	public Booking findOne(Long id) {
		return bookingDao.findOne(id);
	}

	public void save(Booking booking) {
		bookingDao.save(booking);
	}

	public void saveFull(Booking booking) {
		Room room = new Room();
		for (int i = 0; i < booking.getRooms().size(); i++) {
			room = new Room();
			room = roomDao.findOne(booking.getRooms().get(i).getId());
			booking.getRooms().get(i).setBooking(booking);
			roomDao.save(room);
		}
		bookingDao.save(booking);
		// booking = bookingDao.findOne(booking.getId());
	}

	public void update(Booking booking) {
		bookingDao.update(booking);
	}

	public void processBooking(Booking booking, int bookingStatus) {
		
		if (bookingStatus == 3) {
			List<Room> rooms = booking.getRooms();
			for (Room room : rooms) {
				room.setAvailable(false);
				roomDao.update(room);
			}
		}
		booking.setBookingStatus(bookingStatus);
		bookingDao.update(booking);
	}
}
