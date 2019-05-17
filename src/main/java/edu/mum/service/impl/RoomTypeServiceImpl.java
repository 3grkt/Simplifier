package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.RoomTypeDao;
import edu.mum.domain.Room;
import edu.mum.domain.RoomType;
import edu.mum.service.RoomTypeService;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{

	@Autowired
	RoomTypeDao roomTypeDao;
	
	@Override
	public List<RoomType> listAll() {
		return roomTypeDao.findAll();
	}

	public void save(RoomType room){
		roomTypeDao.save(room);
	}
	
	public void update(RoomType room){
		roomTypeDao.update(room);
	}
	
 	public RoomType findOne(Long id) {
		return roomTypeDao.findOne(id);
	}
 	public void delete(Long id){
 		roomTypeDao.delete(id);
 	}
}
