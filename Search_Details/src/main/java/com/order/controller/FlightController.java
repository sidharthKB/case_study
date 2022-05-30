package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Flight_Details;
import com.order.service.FlightService;
import com.order.utilities.GlobalResources;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {
	@Autowired
	private FlightService flightService;

	private Logger logger = GlobalResources.getLogger(FlightController.class);

	// this is to get All Order details
	@GetMapping("/getall")
	public ResponseEntity<List<Flight_Details>> getAllFlight() {

		List<Flight_Details> list = flightService.getAllFlight();
		String methodName = "(Get All Details Of Order)";
		logger.info(methodName + "Called");

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}

	// This is use to add new Flight
	@PostMapping("/addFlight")
	public ResponseEntity<Flight_Details> addFlight(@RequestBody Flight_Details Flight) {
		String methodName = "(Data Added TO Flights)";
		logger.info(methodName + "Called");
		try {
			System.out.println(Flight);
			flightService.setFlight(Flight);
			return ResponseEntity.ok(Flight);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// this is use to get flight by id
	@GetMapping("/flight-id/{id}")
	public ResponseEntity<Flight_Details> getFlightByflightId(@PathVariable("id") int id) {
		String methodName = "(Get Data  Of Order by id)";
		logger.info(methodName + "Called");

		try {
			Flight_Details flight = flightService.getFlightByflightId(id);
			return ResponseEntity.of(Optional.of(flight));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
