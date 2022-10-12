package com.microservice.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservice.reservation.entity.Reservation;

@Service
public interface ReservationService {
	
	String addReservation(Reservation reservation);
	
	List<Reservation> getAllReservation();
	
	Optional<Reservation> getReservationById(int reservationId);
	
	void updateReservation(Reservation reservation,int reservationId);
	
	String deleteReservation(int reservationId);
}
