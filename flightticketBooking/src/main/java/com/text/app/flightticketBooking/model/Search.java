package com.text.app.flightticketBooking.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Search {
	@NonNull
	private String source;
	@NonNull
	private String destination;
	private LocalDate journeyDate;
	private LocalDate returnDate;
	private String roundTrip;
	private String oneWay;
}
