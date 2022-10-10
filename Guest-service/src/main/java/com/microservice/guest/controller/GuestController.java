package com.microservice.guest.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.microservice.guest.entity.Guest;
import com.microservice.guest.service.GuestService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/guest")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@PostMapping("/add")
	@ApiOperation(value = "Adds the Guest of given ID")
	public String addGuest(@RequestBody Guest guest) {
		this.guestService.addGuest(guest);
		return "Guest added with guestId "+guest.getGuestId();
	}
	
	@GetMapping("/get")
	@ApiOperation(value = "Shows the list of all guests")
	public List<Guest> getAllGuest(){
		return this.guestService.getAllGuest();
	}
	
	@GetMapping("/get/{gId}")
	@ApiOperation(value = "shows the guest details of the given Id")
	public Optional<Guest> getGuestById(@PathVariable long gId){
		return this.guestService.getGuestById(gId);
	}
	
	@PutMapping("/update/{gId}")
	@ApiOperation(value = "Updates the guest details of the given Id")
	public String updateGuest(@RequestBody Guest guest,@PathVariable long gId) {
		this.guestService.updateGuest(gId, guest);
		return "Guest updated with guestId "+gId;
	}
	
	@DeleteMapping("/delete/{gId}")
	@ApiOperation(value = "Deletes the Guest of given ID")
	public String deleteGuest(@PathVariable long gId) {
		this.guestService.deleteGuest(gId);
		return "Guest deleted with guestId "+gId;
	}
}
