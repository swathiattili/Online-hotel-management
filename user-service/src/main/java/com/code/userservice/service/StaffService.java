package com.code.userservice.service;

import com.code.userservice.entity.Staff;
import com.code.userservice.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService  {

	@Autowired
	private StaffRepository staffRepository;
	

	public void addStaff(Staff staff) {
		staffRepository.save(staff);
	}


	public List<Staff> getAllStaff() {
		return staffRepository.findAll();
	}


	public Optional<Staff> getStaffById(long staffId) {
		return staffRepository.findById(staffId);
	}


	public void updateStaff(long staffId, Staff staff) {
		staffRepository.save(staff);
	}


	public void deleteStaff(long staffId) {
		staffRepository.deleteById(staffId);
	}


	public List<Staff> getStaffByName(String staffName) {
		return staffRepository.findByStaffName(staffName);
	}
	
}
