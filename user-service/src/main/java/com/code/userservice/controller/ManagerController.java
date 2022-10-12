package com.code.userservice.controller;

import com.code.userservice.entity.Inventory;
import com.code.userservice.entity.Room;
import com.code.userservice.entity.Staff;
import com.code.userservice.service.InventoryService;
import com.code.userservice.service.RoomService;
import com.code.userservice.service.StaffService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/Manager")
public class ManagerController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private InventoryService inventoryService;


    //------------------------------------------Room-------------------------------------------------------------------
    @PostMapping("/addRoom")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
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
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views all Room")
    public List<Room> getAllRooms(){

        return this.roomService.getAllRoom();


    }

    @GetMapping("/getRoom/{roomId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views Specific Room using ID")
    public Optional<Room> getInventoryById(@PathVariable long roomId) {

        return this.roomService.getRoomById(roomId);

    }

    @PutMapping("/updateRoom/{roomId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Upadtes the Room of given ID")
    public String updateRoom(@RequestBody Room room,@PathVariable long roomId) {
        this.roomService.updateRoom(roomId, room);
        return "Room updated with roomNumber "+roomId;
    }

    @DeleteMapping("/deleteRoom/{roomId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Deletes the Inventory of given ID")
    public String deleteRoom(@PathVariable long roomId) {
        this.roomService.deleteRoom(roomId);
        return "Room deleted with roomNumber "+roomId;
    }

    @GetMapping("/searchRoom/{roomAvailable}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Searches for Rooms ")
    public List<Room> getAvailableRoom(@PathVariable boolean roomAvailable){
        return this.roomService.getAvailableRoom(roomAvailable);
    }



    //------------------------------------------Staff-------------------------------------------------------------------
    @PostMapping("/addStaff")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Adding Staff Details")
    public String addStaff(@RequestBody Staff Staff) {
        this.staffService.addStaff(Staff);
        return "Staff added with StaffId "+Staff.getStaffId();
    }

    @GetMapping("/getStaff")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views all Staff Details")
    public List<Staff> getAllStaff(){
        return this.staffService.getAllStaff();
    }

    @GetMapping("/getStaff/{sId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views Specific Staff Details using ID")
    public Optional<Staff> getStaffById(@PathVariable long sId){
        return this.staffService.getStaffById(sId);
    }

    @PutMapping("/updateStaff/{sId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Upadtes the Staff Details of given ID")
    public String updateStaff(@RequestBody Staff Staff,@PathVariable long sId) {
        this.staffService.updateStaff(sId, Staff);
        return "Staff updated with StaffId "+sId;
    }

    @DeleteMapping("/deleteStaff/{sId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Deletes the Staff Details of given ID")
    public String deleteStaff(@PathVariable long sId) {
        this.staffService.deleteStaff(sId);
        return "Staff deleted with StaffId"+sId;
    }

    @GetMapping("/getStaff/")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views Specific Staff Details using Name")
    public List<Staff> getStaffByName(@RequestParam(value="staffName") String staffName){
        return this.staffService.getStaffByName(staffName);
    }

    //------------------------------------------Inventory-------------------------------------------------------------------
    @PostMapping("/addInventory")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Adding Inventory")
    public String addInventory(@RequestBody Inventory inventory) {

        this.inventoryService.addInventory(inventory);
        return "Added inventory with id "+ inventory.getInventoryId();
    }

    @GetMapping("/getInventory")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views all Inventory")
    public List<Inventory> getAllInventory(){
        return this.inventoryService.getAllInventory();
    }

    @GetMapping("/getInventory/{invId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Views Specific Inventory using ID")
    public Optional<Inventory> getInventoryById(@PathVariable int invId) {
        return this.inventoryService.getInventoryById(invId);
    }

    @PutMapping("/updateInventory/{invId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Upadtes the Inventory of given ID")
    public String updateInventory(@RequestBody Inventory inventory,@PathVariable int invId) {
        this.inventoryService.updateInventory(invId, inventory);
        return "Updated inventory with id "+invId;
    }


    @DeleteMapping("/deleteInventory/{invId}")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ApiOperation(value = "Deletes the Inventory of given ID")
    public String deleteInventory(@PathVariable int invId) {
        this.inventoryService.deleteInvenotry(invId);
        return "Deleted inventory with id "+invId;
    }


}
