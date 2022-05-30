package com.bookingdetails.model;

public class Flight_Details {

	private String flightId;
	private String flightName;
	private String flightOrigin;
	private String flightDestination;
	private String flightArrival;
	private String flightDeparture;
	private int flightDuration;
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightOrigin() {
		return flightOrigin;
	}
	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}
	public String getFlightDestination() {
		return flightDestination;
	}
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	public String getFlightArrival() {
		return flightArrival;
	}
	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}
	public String getFlightDeparture() {
		return flightDeparture;
	}
	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}
	public int getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}
	public Flight_Details(String flightId, String flightName, String flightOrigin, String flightDestination,
			String flightArrival, String flightDeparture, int flightDuration) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightOrigin = flightOrigin;
		this.flightDestination = flightDestination;
		this.flightArrival = flightArrival;
		this.flightDeparture = flightDeparture;
		this.flightDuration = flightDuration;
	}
	@Override
	public String toString() {
		return "Customers [flightId=" + flightId + ", flightName=" + flightName + ", flightOrigin=" + flightOrigin
				+ ", flightDestination=" + flightDestination + ", flightArrival=" + flightArrival + ", flightDeparture="
				+ flightDeparture + ", flightDuration=" + flightDuration + "]";
	}
	
	
}
