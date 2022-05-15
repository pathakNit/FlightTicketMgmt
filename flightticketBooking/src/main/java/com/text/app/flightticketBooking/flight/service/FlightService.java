package com.text.app.flightticketBooking.flight.service;

import java.util.List;

import com.text.app.flightticketBooking.model.Plane;

public interface FlightService {

	public List<Plane> addMultipleFlights(List<Plane> planes);

	public Plane addPlane(Plane plane);

}
