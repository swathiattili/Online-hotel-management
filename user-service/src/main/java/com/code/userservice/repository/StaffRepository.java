package com.code.userservice.repository;

import com.code.userservice.entity.Staff;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff,Long>{

	public List<Staff> findByStaffName(String staffName);
}
