package com.bookingdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookingdetails.model.Bookings;
import com.bookingdetails.model.User;



public interface BookingRepository  extends MongoRepository<Bookings,Integer>{

	public Bookings findByBookingReferenceId(int BookingReferenceId);
	//public Bookings getBookingsById(int BookingReferenceId);
}
