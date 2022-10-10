package com.code.userservice.controller;

import com.code.userservice.entity.*;
import com.code.userservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/Owner")
public class OwnerController {

    @Autowired
    private GuestService guestService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ReservationService reservationService;

    //------------------------------------------Guest-------------------------------------------------------------------


    @PostMapping("/addGuest")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Adds the Guest of given ID")
    public String addGuest(@RequestBody Guest guest) {
        this.guestService.addGuest(guest);
        return "Guest added with guestId "+guest.getGuestId();
    }

    @GetMapping("getGuest")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Shows the list of all guests")
    public List<Guest> getAllGuest(){
        return this.guestService.getAllGuest();
    }

    @GetMapping("/getGuest/{gId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "shows the guest details of the given Id")
    public Optional<Guest> getGuestById(@PathVariable long gId){
        return this.guestService.getGuestById(gId);
    }

    @PutMapping("/updateGuest/{gId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Updates the guest details of the given Id")
    public String updateGuest(@RequestBody Guest guest,@PathVariable long gId) {
        this.guestService.updateGuest(gId, guest);
        return "Guest updated with guestId "+gId;
    }

    @DeleteMapping("/deleteGuest/{gId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Deletes the Guest of given ID")
    public String deleteGuest(@PathVariable long gId) {
        this.guestService.deleteGuest(gId);
        return "Guest deleted with guestId "+gId;
    }

    //------------------------------------------Room-------------------------------------------------------------------

    @PostMapping("/addRoom")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Adding Room")
    public String addRoom(@RequestBody Room room) {
        try {
            this.roomService.addRoom(room);
            return "Room added with roomNumber "+room.getRoomId();
        } catch (Exception e) {
            System.out.println(e);
            return "Use Valid Input";
        }
    }

    @GetMapping("/getRoom")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views all Room")
    public List<Room> getAllRooms(){

        return this.roomService.getAllRoom();


    }

    @GetMapping("/getRoom/{roomId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views Specific Room using ID")
    public Optional<Room> getInventoryById(@PathVariable long roomId) {

        return this.roomService.getRoomById(roomId);

    }

    @PutMapping("/updateRoom/{roomId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Upadtes the Room of given ID")
    public String updateRoom(@RequestBody Room room,@PathVariable long roomId) {
        this.roomService.updateRoom(roomId, room);
        return "Room updated with roomNumber "+roomId;
    }

    @DeleteMapping("/deleteRoom/{roomId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Deletes the Inventory of given ID")
    public String deleteRoom(@PathVariable long roomId) {
        this.roomService.deleteRoom(roomId);
        return "Room deleted with roomNumber "+roomId;
    }

    @GetMapping("/searchRoom/{roomAvailable}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Searches for Rooms ")
    public List<Room> getAvailableRoom(@PathVariable boolean roomAvailable){
        return this.roomService.getAvailableRoom(roomAvailable);
    }



    //------------------------------------------Staff-------------------------------------------------------------------
    @PostMapping("/addStaff")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Adding Staff Details")
    public String addStaff(@RequestBody Staff Staff) {
        this.staffService.addStaff(Staff);
        return "Staff added with StaffId "+Staff.getStaffId();
    }

    @GetMapping("/getStaff")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views all Staff Details")
    public List<Staff> getAllStaff(){
        return this.staffService.getAllStaff();
    }

    @GetMapping("/getStaff/{sId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views Specific Staff Details using ID")
    public Optional<Staff> getStaffById(@PathVariable long sId){
        return this.staffService.getStaffById(sId);
    }

    @PutMapping("/updateStaff/{sId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Upadtes the Staff Details of given ID")
    public String updateStaff(@RequestBody Staff Staff,@PathVariable long sId) {
        this.staffService.updateStaff(sId, Staff);
        return "Staff updated with StaffId "+sId;
    }

    @DeleteMapping("/deleteStaff/{sId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Deletes the Staff Details of given ID")
    public String deleteStaff(@PathVariable long sId) {
        this.staffService.deleteStaff(sId);
        return "Staff deleted with StaffId"+sId;
    }

    @GetMapping("/getStaff/")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views Specific Staff Details using Name")
    public List<Staff> getStaffByName(@RequestParam(value="staffName") String staffName){
        return this.staffService.getStaffByName(staffName);
    }

    //------------------------------------------Inventory-------------------------------------------------------------------
    @PostMapping("/addInventory")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Adding Inventory")
    public String addInventory(@RequestBody Inventory inventory) {

        this.inventoryService.addInventory(inventory);
        return "Added inventory with id "+ inventory.getInventoryId();
    }

    @GetMapping("/getInventory")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views all Inventory")
    public List<Inventory> getAllInventory(){
        return this.inventoryService.getAllInventory();
    }

    @GetMapping("/getInventory/{invId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views Specific Inventory using ID")
    public Optional<Inventory> getInventoryById(@PathVariable int invId) {
        return this.inventoryService.getInventoryById(invId);
    }

    @PutMapping("/updateInventory/{invId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Upadtes the Inventory of given ID")
    public String updateInventory(@RequestBody Inventory inventory,@PathVariable int invId) {
        this.inventoryService.updateInventory(invId, inventory);
        return "Updated inventory with id "+invId;
    }


    @DeleteMapping("/deleteInventory/{invId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Deletes the Inventory of given ID")
    public String deleteInventory(@PathVariable int invId) {
        this.inventoryService.deleteInvenotry(invId);
        return "Deleted inventory with id "+invId;
    }

    //------------------------------------------Reservations-------------------------------------------------------------------
    @PostMapping("/addReservation")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Adding Reservation Details")
    public String addReservation(@RequestBody Reservation reservation) {
        return this.reservationService.addReservation(reservation);
    }

    @GetMapping("/getReservation")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views all Reservation Details")
    public List<Reservation> getAllReservation(){
        return this.reservationService.getAllReservation();
    }

    @GetMapping("/getReservation/{reservationId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Views Specific Reservation Details using ID")
    public Optional<Reservation> getReservationById(@PathVariable int reservationId){
        return this.reservationService.getReservationById(reservationId);
    }

    @PutMapping("/updateReservation/{reservationId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Upadtes the Reservation Details of given ID")
    public String updateReservation (@RequestBody Reservation reservation,@PathVariable int reservationId) {
        this.reservationService.updateReservation(reservation, reservationId);
        return "Reservation updated for ID "+reservationId;
    }

    @DeleteMapping("/deleteReservation/{reservationId}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    @ApiOperation(value = "Deletes the Reservation Details of given ID")
    public String deleteReservation(@PathVariable int reservationId) {
        return this.reservationService.deleteReservation(reservationId);
    }

    }
