package edu.mum.service;

import java.util.List;

import edu.mum.domain.Room;

public interface RoomService {
	public List<Room> listAll();
	public List<Room> listAvailableRooms(Boolean availability);
	public void save(Room room);
	public void update(Room room);
	public Room findOne(Long id);
	public void delete(Long id);
}
