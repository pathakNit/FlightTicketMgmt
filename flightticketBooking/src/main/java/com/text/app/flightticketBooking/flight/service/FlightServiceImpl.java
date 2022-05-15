package com.text.app.flightticketBooking.flight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.app.flightticketBooking.constant.ApplicationUtil;
import com.text.app.flightticketBooking.model.Plane;
import com.text.app.flightticketBooking.repository.PlaneRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	PlaneRepository repo;

	@Override
	public List<Plane> addMultipleFlights(List<Plane> planes) {
		planes.stream().map(p -> {
			p = ApplicationUtil.assignAirportNameAccordingToLocation(p);
			p = ApplicationUtil.assignSeats(p);
			return p;
		}).collect(Collectors.toList());
		return repo.saveAll(planes);
	}

	@Override
	public Plane addPlane(Plane plane) {
		plane = ApplicationUtil.assignAirportNameAccordingToLocation(plane);
		plane = ApplicationUtil.assignSeats(plane);
		return repo.save(plane);
	}

}
