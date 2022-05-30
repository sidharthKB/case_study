package com.bookingdetails.controller;
//import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
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

import com.bookingdetails.model.Bookings;

import com.bookingdetails.model.User;
import com.bookingdetails.services.BookingService;
import com.bookingdetails.services.UserService;
import com.bookingdetails.utilities.GlobalResources;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;


	// LOGGER
	private Logger logger = GlobalResources.getLogger(BookingController.class);

	// this is to get All User details
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> list = userService.getAllUser();
		String methodName = "(Get All Details Of User)";
		logger.info(methodName + "Called");

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}

	@GetMapping("/get-user/{username}")
	public ResponseEntity<User> getUserByusername(@PathVariable("username") String username) {
		try {
			String methodName = "getUserByUsername()";
			logger.info(methodName + "Called");
			User user = userService.findByusername(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// This is use to add new User
	@PostMapping("/User")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		String methodName = "(Data Added TO User)";
		logger.info(methodName + "Called");
		try {
			System.out.println(user);
			userService.setUser(user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// this is use to update user
	@PutMapping("/update/{username}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("username") String username) {
		String methodName = "(Update Data  Of User)";
		logger.info(methodName + "Called");
		User user1 = null;
		try {
			user = userService.updateUserByusername(user);
			return ResponseEntity.ok().body(user1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// this is use to delete user
	@DeleteMapping("delete/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String username) {
		String methodName = "(Delete data  Of user by username)";
		logger.info(methodName + "Called");
		try {
			User user = userService.getUserByusername(username);
			userService.deleteUserByusername(username);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	

	// this is use to add bookings
	@PostMapping("/booking")
	public ResponseEntity<Bookings> addBookings(@RequestBody Bookings bookings) {
		String methodName = "(Data Added TO Customer)";
		logger.info(methodName + "Called");
		try {
			System.out.println(bookings);
			bookingService.setBookings(bookings);
			return ResponseEntity.ok(bookings);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}


	 //this is use to get User by id
	@GetMapping("/booking/{id}")
	public ResponseEntity<Bookings> getBookingsByBookingReferenceId(@PathVariable("id") int getBookingsByBookingReferenceId) {
		String methodName = "(Get Data  Of Booking by id)";
		logger.info(methodName + "Called");

		try {
			Bookings bookings = bookingService.getBookingsByBookingReferenceId(getBookingsByBookingReferenceId);
			return ResponseEntity.of(Optional.of(bookings));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}

	   
	