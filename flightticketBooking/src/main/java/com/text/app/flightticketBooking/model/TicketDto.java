package com.text.app.flightticketBooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

	private String passengerName;

	private String departing;

	private String arriving;

	private String stoppage;

	private LocalDate date;

	private LocalTime time;

	private String flightName;

	private String flightCompany;

	private String seat;

	private boolean food;

	private boolean safeJourney;

	private LocalTime onboardingTime;

	private double flightPrice;

	private double tax;

	private double totalFair;

}
