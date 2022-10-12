package com.code.userservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "ReservationDetails")
public class Reservation {

	@Id
	private int reservationId;
	private int roomId;
	private int guestId;
	@NotNull(message="Date cannot be null")
	private String checkInDate;
	@NotNull(message="Date cannot be null")
	private String checkOutDate;
	private int numOfGuest;
	private double totalPrice;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumOfGuest() {
		return numOfGuest;
	}
	public void setNumOfGuest(int numOfGuest) {
		this.numOfGuest = numOfGuest;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Reservation(@NotNull(message="Reservation ID cannnot be null")
	int reservationId, int roomId, int guestId, @NotNull(message="Date cannot be null")
	String checkInDate, @NotNull(message="Date cannot be null") String  checkOutDate, int numOfGuest, double totalPrice) {
		super();
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.guestId = guestId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numOfGuest = numOfGuest;
		this.totalPrice = totalPrice;
	}
	public Reservation() {
		
	}
	
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", roomId=" + roomId + ", guestId=" + guestId
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numOfGuest=" + numOfGuest
				+ ", totalPrice=" + totalPrice + "]";
	}
		
}
