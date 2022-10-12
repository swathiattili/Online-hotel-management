package com.microservice.room.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.microservice.room.entity.Room;
import com.microservice.room.service.RoomService;

import io.swagger.annotations.ApiOperation;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping("/add")
	@ApiOperation(value = "Adding Room")
	public String addRoom(@RequestBody Room room) {
		try {
				this.roomService.addRoom(room);
				return "Room added with roomNumber "+room.getRoomId();
		} catch (Exception e) {
			System.out.println(e);
			return "Use Valid Input";
		}	
	}
	
	@GetMapping("/get")
	@ApiOperation(value = "Views all Room")
	public List<Room> getAllRooms(){

			return this.roomService.getAllRoom();

		
	}
	
	@GetMapping("/get/{roomId}")
	@ApiOperation(value = "Views Specific Room using ID")
	public Optional<Room> getInventoryById(@PathVariable long roomId) {

			return this.roomService.getRoomById(roomId);
		
	}
	
	@PutMapping("/update/{roomId}")
	@ApiOperation(value = "Upadtes the Room of given ID")
	public String updateRoom(@RequestBody Room room,@PathVariable long roomId) {
			this.roomService.updateRoom(roomId, room);
			return "Room updated with roomNumber "+roomId;
	}
	
	@DeleteMapping("/delete/{roomId}")
	@ApiOperation(value = "Deletes the Inventory of given ID")
	public String deleteRoom(@PathVariable long roomId) {
			this.roomService.deleteRoom(roomId);
			return "Room deleted with roomNumber "+roomId;
	}
	
	@GetMapping("/search/{roomAvailable}")
	@ApiOperation(value = "Searches for Rooms ")
	public List<Room> getAvailableRoom(@PathVariable boolean roomAvailable){
	return this.roomService.getAvailableRoom(roomAvailable);
	}
}
