package edu.mum.domain;

public enum BookingStatus {
	PENDING,
	REJECTED,
	APPROVED;
	
	public int getBookingStatus(BookingStatus e){
		switch (e) {
		case PENDING:
			return 1;
		case REJECTED:
			return 2;
		case APPROVED:
			return 3;
		default:
			return 1;
		}

	}
}
