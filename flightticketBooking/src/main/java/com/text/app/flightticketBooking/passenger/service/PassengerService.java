package com.text.app.flightticketBooking.passenger.service;

import com.text.app.flightticketBooking.model.Passenger;
import com.text.app.flightticketBooking.model.TicketDto;

public interface PassengerService {

	public TicketDto bookTicketForPassenger(Passenger passenger);
}
