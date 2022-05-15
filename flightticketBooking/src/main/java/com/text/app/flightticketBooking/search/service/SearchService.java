package com.text.app.flightticketBooking.search.service;

import java.util.List;


import com.text.app.flightticketBooking.model.Plane;
import com.text.app.flightticketBooking.model.Search;

public interface SearchService {
	
	public List<Plane> getFlightsAsPerSearch(Search search) throws Exception;
	
}
