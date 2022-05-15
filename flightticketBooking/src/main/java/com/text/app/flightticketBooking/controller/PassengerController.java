package com.text.app.flightticketBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.app.flightticketBooking.constant.ApplicationConstant;
import com.text.app.flightticketBooking.model.Passenger;
import com.text.app.flightticketBooking.passenger.service.PassengerService;

@CrossOrigin
@RestController
@RequestMapping(ApplicationConstant.PASSENGER)
public class PassengerController {

	@Autowired
	PassengerService service;

	@PostMapping(ApplicationConstant.BOOK_TICKET)
	public ResponseEntity<Object> addPassenger(@RequestBody Passenger passenger) {
		System.out.println("Inside Controllr");
		try {
			service.bookTicketForPassenger(passenger);
			return new ResponseEntity<>(service.bookTicketForPassenger(passenger), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
