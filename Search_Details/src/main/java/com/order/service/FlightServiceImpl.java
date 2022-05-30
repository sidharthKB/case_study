package com.order.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.exceptions.CustomerNotFoundException;
import com.order.model.Flight_Details;
import com.order.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository FlightRepository;

	@Override
	public List<Flight_Details> getAllFlight() {

		return  FlightRepository.findAll();
	}

	@Override
	public Flight_Details getFlightByflightId(int id) {

		return  FlightRepository.findByflightId(id);
	}

	@Override
	public Flight_Details findByflightName(String name) {

		Flight_Details flight =  FlightRepository.findAll().stream().filter(a -> a.getFlightName().equalsIgnoreCase(name))
				.findAny().orElseThrow(null);
		if (flight == null) {

			throw new CustomerNotFoundException(
					"Customer with the provided name is not found, please use the name which was used at the time of registration!");

		} else {
			return flight;
		}
	}

	@Override
	public void setFlight(Flight_Details flight) {
//		 FlightRepository.save(order);
		
	        Random random = new Random();
	        flight.setFlightId(random.nextInt(9999));
	        flight.setPaymentStatus("Done");
	   
	        FlightRepository.save(flight);
	  
	    }

	@Override
	public Flight_Details updateFlightByflightId(Flight_Details flight) {
		
		return  FlightRepository.save(flight);

	}

}
