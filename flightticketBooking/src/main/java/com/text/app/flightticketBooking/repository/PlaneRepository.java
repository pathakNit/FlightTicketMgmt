package com.text.app.flightticketBooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.text.app.flightticketBooking.model.Plane;

@Repository
public interface PlaneRepository extends MongoRepository<Plane, String> {

}
