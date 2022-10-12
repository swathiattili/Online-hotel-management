package com.code.userservice.controller;
import com.code.userservice.entity.Role;
import com.code.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/Receptionist")
    @PreAuthorize("hasRole('ROLE_RECEPTIONIST')")
    public String ReceptionistAccess() {
     return "Receptionist Content.";
    }


    @GetMapping("/Manager")
    @PreAuthorize("hasRole('ROLE_MANAGER') ")
    public String ManagerAccess() {
        return "Manager Content.";
    }


    @GetMapping("/Owner")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public String OwnerAccess() {

        return"Owner Content";

    }
}