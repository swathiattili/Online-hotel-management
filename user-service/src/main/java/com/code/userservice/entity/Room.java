package com.code.userservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Document(collection = "Rooms")
public class Room {
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
