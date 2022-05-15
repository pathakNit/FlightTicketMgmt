package com.text.app.flightticketBooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.app.flightticketBooking.constant.ApplicationConstant;
import com.text.app.flightticketBooking.flight.service.FlightService;
import com.text.app.flightticketBooking.model.Plane;
import com.text.app.flightticketBooking.repository.PlaneRepository;

@CrossOrigin
@RestController
@RequestMapping(ApplicationConstant.FLIGHT)
public class PlaneController {

	@Autowired
	PlaneRepository repo;

	@Autowired
	FlightService service;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<>("Welcome ji", HttpStatus.OK);
	}

	@PostMapping(ApplicationConstant.ADD)
	public ResponseEntity<Object> addFlight(@RequestBody Plane plane) {
		try {
			return new ResponseEntity<>(service.addPlane(plane), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(ApplicationConstant.UPDATE)
	public ResponseEntity<Object> updateFlight(@PathVariable("id") String id, @RequestBody Plane plane) {
		try {
			Plane updated = convertObect(plane, repo.findById(id));
			System.out.println("after update existing oject: " + updated);
			return new ResponseEntity<>(repo.save(updated), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Plane convertObect(Plane plane, Optional<Plane> findById) {
		Plane existing = findById.get();
		existing.setAirCraftType(plane.getAirCraftType());
		existing.setDestination(plane.getDestination());
		existing.setEndTime(plane.getEndTime());
		existing.setFlightCompany(plane.getFlightCompany());
		existing.setFlightName(plane.getFlightName());
		existing.setJourneyDate(plane.getJourneyDate());
		existing.setRouteType(plane.getRouteType());
		existing.setStartFrom(plane.getStartFrom());
		existing.setStartTime(plane.getStartTime());
		existing.setStopageLocation(plane.getStopageLocation());
		existing.setStoppage(plane.isStoppage());
		return existing;

	}

	@DeleteMapping(ApplicationConstant.DELETE)
	public ResponseEntity<Object> removeFlight(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			String message = "Deleted Successfully";
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(ApplicationConstant.SHOW_ALL)
	public ResponseEntity<Object> getAllFlights() {
		try {
			return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(ApplicationConstant.ADD_ALL)
	public ResponseEntity<Object> storeMultipleObjects(@RequestBody List<Plane> planes) {
		try {
			return new ResponseEntity<>(service.addMultipleFlights(planes), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
