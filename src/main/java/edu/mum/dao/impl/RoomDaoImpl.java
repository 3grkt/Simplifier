package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.RoomDao;
import edu.mum.domain.Room;


@SuppressWarnings("unchecked")
@Repository
public class RoomDaoImpl extends GenericDaoImpl<Room> implements RoomDao {

	public RoomDaoImpl() {
		super.setDaoType(Room.class );
		}

	public List<Room> findAvailableRooms(Boolean availability){
        Query query = entityManager.createQuery("select r from Room r  where r.available =:availability");
		return (List<Room>) query.setParameter("availability", availability).getResultList();
	}
	
 }