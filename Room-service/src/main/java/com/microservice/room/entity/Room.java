package com.microservice.room.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Rooms")
public class Room {
	@Transient
	public static final String SEQUENCE_NAME="room_sequence";
	@Id
	private long roomId;
	@NotNull(message="Room type be null")
	private String roomType;
	@NotNull(message="Room rent cannnot be null")
	private double roomRent;
	@NotNull(message="Room avaialble cannnot be null")
	private boolean roomAvailable;
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(double roomRent) {
		this.roomRent = roomRent;
	}
	public boolean isRoomAvailable() {
		return roomAvailable;
	}
	public void setRoomAvailable(boolean roomAvailable) {
		this.roomAvailable = roomAvailable;
	}

	public Room(@NotNull(message="Room ID cannnot be null")long roomId,
			@NotNull(message="Room type be null")String roomType,
			@NotNull(message="Room rent cannnot be null")double roomRent,
			@NotNull(message="Room avaialble cannnot be null")boolean roomAvailable) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomAvailable = roomAvailable;
	}
	public Room() {
	
	}
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomRent=" + roomRent
				+ ", roomAvailable=" + roomAvailable + "]";
	}
	
}
