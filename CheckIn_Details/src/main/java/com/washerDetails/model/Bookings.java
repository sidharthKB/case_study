package com.washerDetails.model;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection="BookingDetails")
public class Bookings {

	@Id
	private String BookingReferenceId;
	private Flight_Details flight;
	private User user;
	public String getBookingReferenceId() {
		return BookingReferenceId;
	}
	public void setBookingReferenceId(String bookingReferenceId) {
		BookingReferenceId = bookingReferenceId;
	}
	public Flight_Details getFlight() {
		return flight;
	}
	public void setFlight(Flight_Details flight) {
		this.flight = flight;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bookings(String BookingReferenceId, Flight_Details flight, User user) {
		super();
		BookingReferenceId = BookingReferenceId;
		this.flight = flight;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Bookings[BookingReferenceId=" + BookingReferenceId + ",flight=" + flight + ", user=" + user + "]";
	}
	

     }
