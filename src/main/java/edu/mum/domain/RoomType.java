package edu.mum.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RoomType implements Serializable {
    private static final long serialVersionUID = 5784L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private long id;
	
	@Column(length = 150)
    private String description;
	
    private String price;
    
    @OneToMany(mappedBy="roomType")
    private List<Room> rooms = new ArrayList<Room>();

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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

 }