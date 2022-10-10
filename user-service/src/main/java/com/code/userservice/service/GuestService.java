package com.code.userservice.service;

import com.code.userservice.entity.Guest;
import com.code.userservice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GuestRepository guestRepository;


    public void addGuest(Guest guest) {

        guestRepository.save(guest);
    }


    public List<Guest> getAllGuest() {

        return guestRepository.findAll();
    }


    public Optional<Guest> getGuestById(long guestId) {
        return guestRepository.findById(guestId);
    }


    public void updateGuest(long guestId, Guest guest) {
        guestRepository.save(guest);
    }

    public void deleteGuest(long guestId) {
        guestRepository.deleteById(guestId);
    }


}
