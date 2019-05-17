package edu.mum.service;

import java.util.List;

import edu.mum.domain.RoomType;

public interface RoomTypeService {
	public List<RoomType> listAll();
	public void save(RoomType room);
	public void update(RoomType room);
	public RoomType findOne(Long id);
	public void delete(Long id);
}
