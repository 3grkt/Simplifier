package edu.mum.dao.impl;

 import java.util.List;

 import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import edu.mum.dao.BookingDao;
import edu.mum.domain.Booking;
import edu.mum.domain.BookingStatus;


@SuppressWarnings("unchecked")
@Repository
public class BookingDaoImpl extends GenericDaoImpl<Booking> implements BookingDao {
	
//	@PersistenceContext
//    private EntityManager em;
//	private EntityManager entityManager;
	
	public BookingDaoImpl() {
		super.setDaoType(Booking.class );
		}

	public List<Booking> findBookingByStatus(int bookStatus){
//		String strQuery = "select b from Booking b where b.bookingStatus =" + bookStatus.getBookingStatus(bookStatus);
		String strQuery = "select b from Booking b where b.bookingStatus =" + bookStatus;
		Query query = entityManager.createQuery(strQuery);
//		query.setParameter("bookingStatus", "" + bookStatus.getBookingStatus(bookStatus));
		return (List<Booking>) query.getResultList();
//		return (List<Booking>) query.setParameter("bookingStatus", BookingStatus.APPROVED).getResultList();
		
	}
}