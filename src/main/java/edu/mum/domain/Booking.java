package edu.mum.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import edu.mum.service.RoomService;

@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 5784L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private long id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Member member;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="agent_id")
	private Member agent;
	
	private Date bookingDate;
	
	private Date checkinDate;
	
	private Date checkoutDate;
	
	private int bookingStatus;
	
	@OneToMany(mappedBy="booking", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<Room>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Member getUser() {
		return member;
	}

	public void setUser(Member member) {
		this.member = member;
	}

	public Member getAgent() {
		return agent;
	}

	public void setAgent(Member agent) {
		this.agent = agent;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}	
	
	public void addRoom(Room room){
		rooms.add(room);
	}
 }