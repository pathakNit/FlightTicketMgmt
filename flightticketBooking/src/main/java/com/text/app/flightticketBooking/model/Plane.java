package com.text.app.flightticketBooking.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "planes")
public class Plane {

	@Id
	private String id;
	private String flightName;
	private String flightCompany;
	private Map<Integer, String> seats;
	private String airCraftType;
	private String startFrom;
	private String destination;
	private LocalDate journeyDate;
	private String routeType;
	private boolean stoppage;
	private String stopageLocation;
	private LocalTime startTime;
	private LocalTime endTime;
	private double price;
	private double foodPrice;

}
