package com.text.app.flightticketBooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.app.flightticketBooking.constant.ApplicationConstant;
import com.text.app.flightticketBooking.model.Plane;
import com.text.app.flightticketBooking.model.Search;
import com.text.app.flightticketBooking.search.service.SearchService;

@CrossOrigin
@RestController
@RequestMapping(ApplicationConstant.SEARCH_FLIGHT)
public class SearchController {

	@Autowired
	private SearchService service;

	@PostMapping(ApplicationConstant.SEARCH)
	public ResponseEntity<Object> getAllFlightsOnSearch(@RequestBody Search search) {
		try {
			System.out.println(">> inside getAllFlightsOnSearch "+ search);
			 List<Plane> flights = service.getFlightsAsPerSearch(search);
			 System.out.println(flights);
			 if(flights.isEmpty() || flights == null) {
				 throw new RuntimeException("Flights not found");
			 }
			 
			return new ResponseEntity<>(flights, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(ApplicationConstant.LOCATIONS)
	public ResponseEntity<Object> getListOfLocations(){
		List<String> listOfLocation = new ArrayList<>();
		try {
			listOfLocation.add(ApplicationConstant.AHMEDABAD);
			listOfLocation.add(ApplicationConstant.CHENNAI);
			listOfLocation.add(ApplicationConstant.COIMBATORE);
			listOfLocation.add(ApplicationConstant.GAYA);
			listOfLocation.add(ApplicationConstant.GOA);
			listOfLocation.add(ApplicationConstant.HYDERABAD);
			listOfLocation.add(ApplicationConstant.INDORE);
			listOfLocation.add(ApplicationConstant.JAIPUR);
			listOfLocation.add(ApplicationConstant.KANNUR);
			listOfLocation.add(ApplicationConstant.KOLKATA);
			listOfLocation.add(ApplicationConstant.LACKNOW);
			listOfLocation.add(ApplicationConstant.MANGALOR);
			listOfLocation.add(ApplicationConstant.MUMBAI);
			listOfLocation.add(ApplicationConstant.NAGPUR);
			listOfLocation.add(ApplicationConstant.NASHIK);
			listOfLocation.add(ApplicationConstant.NEW_DELHI);
			listOfLocation.add(ApplicationConstant.PATNA);
			listOfLocation.add(ApplicationConstant.SURAT);
			listOfLocation.add(ApplicationConstant.TIRUCHIRAPPALLI);
			listOfLocation.add(ApplicationConstant.VADODARA);
			listOfLocation.add(ApplicationConstant.VARANASI);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(listOfLocation, HttpStatus.OK);
	}
	

}
