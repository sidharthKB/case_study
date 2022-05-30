package com.washerDetails.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.washerDetails.model.CheckIn;

import com.washerDetails.service.CheckInService;
import com.washerDetails.utilities.GlobalResources;

@RestController
@RequestMapping("/CheckIn")
@CrossOrigin("*")
public class CheckInController {
	
	@Autowired
	private CheckInService service;
	
	
	
	// LOGGER
		private Logger logger = GlobalResources.getLogger(CheckInController.class);
	
	//THIS IS USE TO GET ALL DATA FROM Washer
	@GetMapping("/")
    public ResponseEntity<List<CheckIn>> getAllFlight() {
		String methodName = "(Get All Details Of Washer)";
		logger.info(methodName + "Called");
        List<CheckIn> list = service.getAllCheckIn();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }


    
	
	
	//this is use to get CheckIn by id
		@GetMapping("/{id}")
	    public ResponseEntity<CheckIn> getCheckInByCheckInId(@PathVariable("id") int CheckInId) {
			String methodName = "(successfully got CheckIn by id)";
			logger.info(methodName + "Called");

	        try {
	        	CheckIn checkIn = service.getCheckInByCheckInId(CheckInId);
	            return ResponseEntity.of(Optional.of(checkIn));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	    }
		
		
		@PostMapping("/addFlight")
		public ResponseEntity<CheckIn> addFlight(@RequestBody CheckIn checkIn) {
			String methodName = "(Data Added TO Flights)";
			logger.info(methodName + "Called");
			try {
				System.out.println(checkIn);
				service.setCheckIn(checkIn);
				return ResponseEntity.ok(checkIn);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}
	
		
	   
}
