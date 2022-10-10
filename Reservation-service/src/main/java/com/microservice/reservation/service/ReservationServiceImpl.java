package com.microservice.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.microservice.reservation.entity.Guest;
import com.microservice.reservation.entity.Reservation;
import com.microservice.reservation.entity.Room;
import com.microservice.reservation.repository.ReservationRepository;

import static com.microservice.reservation.entity.Reservation.SEQUENCE_NAME;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	public SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String addReservation(Reservation reservation) {
		reservation.setReservationId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
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

	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}

	@Override
	public Optional<Reservation> getReservationById(int reservationId) {
		return reservationRepository.findById(reservationId);
	}

	@Override
	public void updateReservation(Reservation reservation, int reservationId) {
		reservationRepository.save(reservation);
	}

	@Override
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
