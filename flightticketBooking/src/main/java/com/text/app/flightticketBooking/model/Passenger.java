package com.text.app.flightticketBooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "passengers")
public class Passenger {

	@Id()
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String departing;
	private String arriving;
	private String uId;
	private boolean insurancedJourney;
	private boolean food;
	private LocalTime journeyStartTime;
	private LocalTime journeyEndTime;
	private boolean physicallyDisabled;
	private String seatNumber;
	private String planeDetails;
	private LocalDate journeyDate;
}
