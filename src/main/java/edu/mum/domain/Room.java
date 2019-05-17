package edu.mum.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room implements Serializable {
    private static final long serialVersionUID = 5784L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private long id;
	
	@Column(length = 150)
    private String description;
	
	private Integer roomNumber;
		
    private float price;
    
    @ManyToOne
    @JoinColumn(name="book_id")
    @JsonIgnore 
    private Booking booking;

	@ManyToOne
    @JoinColumn(name="typeId")
    @JsonIgnore 
    private RoomType roomType;
    
    private Integer capacity;
    
    private Integer numBed;

    private boolean available;
    
     public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

	public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getNumBed() {
		return numBed;
	}
	public void setNumBed(Integer numBed) {
		this.numBed = numBed;
	}
    
    public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
 }