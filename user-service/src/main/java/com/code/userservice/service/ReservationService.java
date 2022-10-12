package com.code.userservice.service;

import com.code.userservice.entity.Guest;
import com.code.userservice.entity.Reservation;
import com.code.userservice.entity.Room;
import com.code.userservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private RestTemplate restTemplate;


	public String addReservation(Reservation reservation) {
		Room room= restTemplate.getForObject("http://localhost:8082/room/get/"+reservation.getRoomId(), Room.class);
		Guest guest=restTemplate.getForObject("http://localhost:8083/guest/get/"+reservation.getGuestId(), Guest.class);
		if(room.isRoomAvailable()) {
			if(guest!=null)
			{
			reservationRepository.save(reservation);
			room.setRoomAvailable(false);
			restTemplate.put("http://localhost:8082/room/update/"+reservation.getRoomId(), room);
			return "Room Number "+room.getRoomId()+" reserved for Guest "+guest.getGuestId();}
			else
			{
				return "guest not found";
			}
		}
		else {
			return "Room Already Booked";
		}
	}


	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}


	public Optional<Reservation> getReservationById(int reservationId) {
		return reservationRepository.findById(reservationId);
	}


	public void updateReservation(Reservation reservation, int reservationId) {
		reservationRepository.save(reservation);
	}

	public String deleteReservation(int reservationId) {
		Optional<Reservation> reOptional=reservationRepository.findById(reservationId);
		Reservation reservation=reOptional.get();
		Room room= restTemplate.getForObject("http://localhost:8082/room/get/"+reservation.getRoomId(), Room.class);
		room.setRoomAvailable(true);
		restTemplate.put("http://localhost:8082/room/update/"+reservation.getRoomId(), room);
		reservationRepository.deleteById(reservationId);
		return "Reservation deleted for ID "+reservationId;
	}
	
}
