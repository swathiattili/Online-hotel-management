package com.code.userservice.controller;

import com.code.userservice.entity.Guest;
import com.code.userservice.entity.Reservation;
import com.code.userservice.service.GuestService;
import com.code.userservice.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/Receptionist")
public class ReceptionistController {
    @Autowired
    private GuestService guestService;
    @Autowired
    private ReservationService reservationService;
    //------------------------------------------Guest-------------------------------------------------------------------


    @PostMapping("/addGuest")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Adds the Guest of given ID")
    public String addGuest(@RequestBody Guest guest) {
        this.guestService.addGuest(guest);
        return "Guest added with guestId "+guest.getGuestId();
    }

    @GetMapping("getGuest")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Shows the list of all guests")
    public List<Guest> getAllGuest(){
        return this.guestService.getAllGuest();
    }

    @GetMapping("/getGuest/{gId}")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "shows the guest details of the given Id")
    public Optional<Guest> getGuestById(@PathVariable long gId){
        return this.guestService.getGuestById(gId);
    }

    @PutMapping("/updateGuest/{gId}")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Updates the guest details of the given Id")
    public String updateGuest(@RequestBody Guest guest,@PathVariable long gId) {
        this.guestService.updateGuest(gId, guest);
        return "Guest updated with guestId "+gId;
    }

    @DeleteMapping("/deleteGuest/{gId}")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Deletes the Guest of given ID")
    public String deleteGuest(@PathVariable long gId) {
        this.guestService.deleteGuest(gId);
        return "Guest deleted with guestId "+gId;
    }

    //------------------------------------------Reservations-------------------------------------------------------------------
    @PostMapping("/addReservation")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Adding Reservation Details")
    public String addReservation(@RequestBody Reservation reservation) {
        return this.reservationService.addReservation(reservation);
    }

    @GetMapping("/getReservation")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Views all Reservation Details")
    public List<Reservation> getAllReservation(){
        return this.reservationService.getAllReservation();
    }

    @GetMapping("/getReservation/{reservationId}")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Views Specific Reservation Details using ID")
    public Optional<Reservation> getReservationById(@PathVariable int reservationId){
        return this.reservationService.getReservationById(reservationId);
    }

    @PutMapping("/updateReservation/{reservationId}")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Upadtes the Reservation Details of given ID")
    public String updateReservation (@RequestBody Reservation reservation,@PathVariable int reservationId) {
        this.reservationService.updateReservation(reservation, reservationId);
        return "Reservation updated for ID "+reservationId;
    }

    @DeleteMapping("/deleteReservation/{reservationId}")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    @ApiOperation(value = "Deletes the Reservation Details of given ID")
    public String deleteReservation(@PathVariable int reservationId) {
        return this.reservationService.deleteReservation(reservationId);
    }


}
