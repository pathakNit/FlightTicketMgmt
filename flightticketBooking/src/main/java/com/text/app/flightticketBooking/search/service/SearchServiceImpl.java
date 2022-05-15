package com.text.app.flightticketBooking.search.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.app.flightticketBooking.model.Plane;
import com.text.app.flightticketBooking.model.Search;
import com.text.app.flightticketBooking.repository.PlaneRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private PlaneRepository planRepo;

	@Override
	public List<Plane> getFlightsAsPerSearch(Search search) throws Exception {
		List<Plane> filteredFlights = planRepo.findAll();
		filteredFlights = filteredFlights.stream()
				.filter(s -> s.getStartFrom().toLowerCase().contains(search.getSource().toLowerCase())
						&& s.getDestination().toLowerCase().contains(search.getDestination().toLowerCase()))
				.collect(Collectors.toList());
		System.out.println("In getFlightsAsPerSearch "+filteredFlights.size());
		if(search.getJourneyDate() == null) {
			return filteredFlights;
		}
//		if(search.getJourneyDate().isBefore(LocalDate.now())) {
//			throw new RuntimeException("Journey date should not be before today!!");
//		}
		return filteredFlights.stream().filter(s -> s.getJourneyDate().isEqual(search.getJourneyDate())).collect(Collectors.toList());
		
	}

}
