package com.text.app.flightticketBooking.passenger.service;

import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.app.flightticketBooking.constant.ApplicationConstant;
import com.text.app.flightticketBooking.model.Passenger;
import com.text.app.flightticketBooking.model.Plane;
import com.text.app.flightticketBooking.model.TicketDto;
import com.text.app.flightticketBooking.repository.PassengerRepository;
import com.text.app.flightticketBooking.repository.PlaneRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepository passengerRepo;

	@Autowired
	PlaneRepository planeRepo;

	@Override
	public TicketDto bookTicketForPassenger(Passenger passenger) {
		System.out.println("inside service:" + passenger);
		if (passenger != null) {
			Plane plane = getFlight(passenger.getPlaneDetails());
			reserveSeat(passenger.getSeatNumber(), plane);
		}
		TicketDto ticket = prepareTicket(passengerRepo.save(passenger));
		return ticket;
	}

	private TicketDto prepareTicket(Passenger passenger) {
		TicketDto ticket = new TicketDto();
		double totalFair = 0;
		Plane plane = getFlight(passenger.getPlaneDetails());
		ticket.setArriving(passenger.getArriving());
		ticket.setDeparting(passenger.getDeparting());
		ticket.setPassengerName(passenger.getFirstName() + " " + passenger.getLastName());
		ticket.setDate(passenger.getJourneyDate());
		ticket.setTime(plane.getStartTime());
		ticket.setFlightName(plane.getFlightName());
		ticket.setFlightCompany(plane.getFlightCompany());
		LocalTime onboardingTime = plane.getStartTime().minusHours(1).minusMinutes(30);
		ticket.setOnboardingTime(onboardingTime);
		totalFair = totalFair + plane.getPrice();
		if (passenger.isFood()) {
			totalFair += plane.getPrice();
		}
		ticket.setFood(passenger.isFood());
		if (plane.isStoppage()) {
			ticket.setStoppage(plane.getStopageLocation());
			totalFair += ApplicationConstant.INDIRECT_FLIGHT_CHARGE;
		} else {
			ticket.setStoppage(ApplicationConstant.NON_STOP);
		}
		if (passenger.isInsurancedJourney()) {
			totalFair += ApplicationConstant.INDIRECT_FLIGHT_CHARGE;
		}
		ticket.setSafeJourney(passenger.isInsurancedJourney());
		ticket.setSeat(passenger.getSeatNumber());
		
//		String seatNumber = confirmSeatForPassenger(passenger.getSeatNumber(), plane);
		
		ticket.setFlightPrice(plane.getPrice());
		ticket.setTax(ApplicationConstant.TAX);
		
		ticket.setTotalFair(calcuateTotalfair(totalFair, passenger.isPhysicallyDisabled()));

		return ticket;
	}

	private double calcuateTotalfair(double totalFair, boolean physicalDisabled) {
		if (physicalDisabled) {
			double tax = ApplicationConstant.TAX - ApplicationConstant.PHYSICAL_DISABLED_DISCOUNT;
			totalFair += (totalFair * tax) / 100;
		} else {
			totalFair += (totalFair * ApplicationConstant.TAX) / 100;
		}
		return totalFair;
	}

	private Plane getFlight(String planeDetails) {
		return planeRepo.findById(planeDetails).get();
	}

	private void reserveSeat(String seatNumber, Plane plane) {
		System.out.println("seatNumber: " + seatNumber);
		int row = (seatNumber.charAt(0) - '1') + 1;
		String col = seatNumber.charAt(1) + "";
		System.out.println("Row: " + row + ",   Col:" + col);
		Map<Integer, String> seats = plane.getSeats();
		System.out.println(seats.size());
		if (seatNumber.length() > 0) {
			for (Map.Entry<Integer, String> entry : seats.entrySet()) {
				System.out.println(entry.getKey() + "   " + entry.getValue());
				if ((entry.getKey() == row) && (entry.getValue().contains(col))) {
					if (!entry.getValue().contains("X")) {
						entry.setValue(entry.getValue().replace(col, "X"));
					} else {
						throw new RuntimeException("Already booked");
					}
				}
			}

		}
		plane.setSeats(seats);
		planeRepo.save(plane);
	}

}
