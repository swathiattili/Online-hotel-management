package com.microservice.room.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.room.entity.Room;
//import com.microservice.room.entity.RoomList;
import com.microservice.room.repository.RoomRepository;

import static com.microservice.room.entity.Room.SEQUENCE_NAME;

@Service
public class RoomServiceImpl  implements RoomService{

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	public SequenceGeneratorService sequenceGeneratorService;


	@Override
	public void addRoom(Room room) {
		room.setRoomId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));

		roomRepository.save(room);
	}

	@Override
	public List<Room> getAllRoom() {
		return roomRepository.findAll();
	}

	@Override
	public Optional<Room> getRoomById(long roomId) {
		return roomRepository.findById(roomId);
	}

	@Override
	public void updateRoom(long roomId, Room room) {
		roomRepository.save(room);
	}

	@Override
	public void deleteRoom(long roomId) {
		roomRepository.deleteById(roomId);
	}

	@Override
	public List<Room> getAvailableRoom(boolean roomAvailable) {
		return roomRepository.findByRoomAvailable(roomAvailable);
	}

}