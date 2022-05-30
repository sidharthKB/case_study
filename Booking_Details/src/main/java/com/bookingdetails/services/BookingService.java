package com.bookingdetails.services;

import java.util.List;

import com.bookingdetails.model.Bookings;

public interface BookingService 
{
    public List<Bookings> getAllBookings();

	public Bookings getBookingsByBookingReferenceId(int BookingReferenceId);
	
	public Bookings findByBookingReferenceId(int BookingReferenceId);

	public void setBookings(Bookings bookings);
    
}
