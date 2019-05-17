package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Room;

public interface RoomDao extends GenericDao<Room> {
      public List<Room> findAvailableRooms(Boolean availability);
 	}
