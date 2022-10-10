package com.microservice.guest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.guest.entity.Guest;
import com.microservice.guest.repository.GuestRepository;

import static com.microservice.guest.entity.Guest.SEQUENCE_NAME;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	public SequenceGeneratorService sequenceGeneratorService;
	@Override
	public void addGuest(Guest guest) {
		guest.setGuestId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));

		guestRepository.save(guest);
	}

	@Override
	public List<Guest> getAllGuest() {

		return guestRepository.findAll();
	}

	@Override
	public Optional<Guest> getGuestById(long guestId) {
		return guestRepository.findById(guestId);
	}

	@Override
	public void updateGuest(long guestId, Guest guest) {
		guestRepository.save(guest);
	}

	@Override
	public void deleteGuest(long guestId) {
		guestRepository.deleteById(guestId);
	}

}
