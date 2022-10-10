package com.code.userservice.service;

import com.code.userservice.entity.Room;
import com.code.userservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	

	public void addRoom(Room room) {
		roomRepository.save(room);
	}


	public List<Room> getAllRoom() {
		return roomRepository.findAll();
	}
	

	public Optional<Room> getRoomById(long roomId) {
		return roomRepository.findById(roomId);
	}


	public void updateRoom(long roomId, Room room) {
		roomRepository.save(room);
	}


	public void deleteRoom(long roomId) {
		roomRepository.deleteById(roomId);
	}
	

	public List<Room> getAvailableRoom(boolean roomAvailable) {
		return roomRepository.findByRoomAvailable(roomAvailable);
	}

}
