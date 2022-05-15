package com.text.app.flightticketBooking.constant;

import java.util.LinkedHashMap;
import java.util.Map;

import com.text.app.flightticketBooking.model.Plane;

public class ApplicationUtil {
	public static Plane assignAirportNameAccordingToLocation(Plane plane) {
		String airportNameForStartLocation = getAirportName(plane.getStartFrom().toLowerCase());
		String airportNameForEndLocation = getAirportName(plane.getDestination().toLowerCase());
		if (plane.isStoppage() && !plane.getStopageLocation().equalsIgnoreCase("NA")) {
			String airportNameForStoppageLocation = getAirportName(plane.getStopageLocation().toLowerCase());
			plane.setStopageLocation(airportNameForStoppageLocation);
		}
		if (airportNameForStartLocation.length() < 1 || airportNameForEndLocation.length() < 1) {
			throw new RuntimeException("Source or Destination Location is not vaid for flight");
		}
		plane.setStartFrom(airportNameForStartLocation);
		plane.setDestination(airportNameForEndLocation);
		return plane;
	}

	public static String getAirportName(String loation) {
		String result = "";
		switch (loation) {
		case ApplicationConstant.PATNA:
			result = ApplicationConstant.PATNA_AIRPORT;
			break;
		case ApplicationConstant.AHMEDABAD:
			result = ApplicationConstant.AHMEDABAD_AIRPORT;
			break;
		case ApplicationConstant.CHENNAI:
			result = ApplicationConstant.CHENNAI_AIRPORT;
			break;
		case ApplicationConstant.COIMBATORE:
			result = ApplicationConstant.COIMBATORE_AIRPORT;
			break;
		case ApplicationConstant.GAYA:
			result = ApplicationConstant.GAYA_AIRPORT;
			break;
		case ApplicationConstant.GOA:
			result = ApplicationConstant.GOA_AIRPORT;
			break;
		case ApplicationConstant.HYDERABAD:
			result = ApplicationConstant.HYDERABAD_AIRPORT;
			break;
		case ApplicationConstant.INDORE:
			result = ApplicationConstant.INDORE_AIRPORT;
			break;
		case ApplicationConstant.JAIPUR:
			result = ApplicationConstant.JAIPUR_AIRPORT;
			break;
		case ApplicationConstant.KANNUR:
			result = ApplicationConstant.KANNUR_AIRPORT;
			break;
		case ApplicationConstant.KOLKATA:
			result = ApplicationConstant.KOLKATA_AIRPORT;
			break;
		case ApplicationConstant.LACKNOW:
			result = ApplicationConstant.LACKNOW_AIRPORT;
			break;
		case ApplicationConstant.MANGALOR:
			result = ApplicationConstant.MANGALOR_AIRPORT;
			break;
		case ApplicationConstant.MUMBAI:
			result = ApplicationConstant.MUMBAI_AIRPORT;
			break;
		case ApplicationConstant.NAGPUR:
			result = ApplicationConstant.NAGPUR_AIRPORT;
			break;
		case ApplicationConstant.NASHIK:
			result = ApplicationConstant.NASHIK_AIRPORT;
			break;
		case ApplicationConstant.NEW_DELHI:
			result = ApplicationConstant.NEW_DELHI_AIRPORT;
			break;
		case ApplicationConstant.SURAT:
			result = ApplicationConstant.SURAT_AIRPORT;
			break;
		case ApplicationConstant.TIRUCHIRAPPALLI:
			result = ApplicationConstant.TIRUCHIRAPPALLI_AIRPORT;
			break;
		case ApplicationConstant.VADODARA:
			result = ApplicationConstant.VADODARA_AIRPORT;
			break;
		case ApplicationConstant.VARANASI:
			result = ApplicationConstant.VARANASI_AIRPORT;
			break;
		default:
			result = "";
			break;
		}
		return result;
	}

	public static Plane assignSeats(Plane plane) {

		Map<Integer, String> seats = new LinkedHashMap<>();
		for (int i = 0; i < 10; i++) {
			seats.put(i + 1, "AB CD");
		}
		plane.setSeats(seats);
		return plane;
	}
}
