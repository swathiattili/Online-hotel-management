package com.microservice.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservice.reservation.entity.Reservation;
import com.microservice.reservation.repository.ReservationRepository;
import com.microservice.reservation.service.ReservationService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationServiceApplicationTests {
	
	@Autowired
	private ReservationService reservationService;
	
	@MockBean
	private ReservationRepository reservationRepository;
	
	@Test
	public void addReservationTest() {
		Reservation reservation=new Reservation(808410000,8082100,80831000,"04-09-2022","2021-05-12",2,6000);
		when(reservationRepository.save(reservation)).thenReturn(reservation);
		reservationService.addReservation(reservation);
		verify(reservationRepository,times(1)).save(reservation);

	}
}
