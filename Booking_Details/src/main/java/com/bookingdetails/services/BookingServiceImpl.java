package com.bookingdetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingdetails.model.Bookings;
import com.bookingdetails.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository BookingRepository;
	
	
	@Override
	public List<Bookings> getAllBookings() {
		
		return BookingRepository.findAll();
	}

	public Object addBookings(Bookings bookings) {
		return null;	
	}
	
    @Override
    public Bookings getBookingsByBookingReferenceId(int BookingReferenceId )
    {
	return BookingRepository.findByBookingReferenceId(BookingReferenceId);
     }
    
    @Override
    public void setBookings(Bookings bookings) {
	BookingRepository.save(bookings);		
     }


	@Override
	public Bookings findByBookingReferenceId(int BookingReferenceId) {
		// TODO Auto-generated method stub
		return null;
	}


}
