package com.code.userservice.repository;

import com.code.userservice.entity.Reservation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, Integer>{

}
