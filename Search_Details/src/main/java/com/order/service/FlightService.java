package com.order.service;

import java.util.List;

import com.order.model.Flight_Details;



public interface FlightService {

	public List<Flight_Details> getAllFlight() ;
	

	public Flight_Details getFlightByflightId(int id);

	public Flight_Details findByflightName(String name);

	public void setFlight(Flight_Details flight);

	public Flight_Details updateFlightByflightId(Flight_Details flight);

	
}
