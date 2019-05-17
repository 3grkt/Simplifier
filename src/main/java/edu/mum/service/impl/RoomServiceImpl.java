package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.RoomDao;
import edu.mum.domain.Member;
import edu.mum.domain.Room;
import edu.mum.service.RoomService;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomDao roomDao;
	
	@Override
	public List<Room> listAll() {
		return roomDao.findAll();
	}

	@Override
	public List<Room> listAvailableRooms(Boolean availability) {
		return roomDao.findAvailableRooms(availability);
	}
	
	public void save(Room room){
		roomDao.save(room);
	}
	
	public void update(Room room){
		roomDao.update(room);
	}
	

 	public Room findOne(Long id) {
		return roomDao.findOne(id);
	}
 	public void delete(Long id){
 		roomDao.delete(id);
 	}

}
