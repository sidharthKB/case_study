package com.washerDetails.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CheckInDetails")
public class CheckIn {

	@NotEmpty(message = "please review the experience, review can't be empty!")
	private int CheckInId;
	private int SeatNo;
	private Bookings booking;
	public int getCheckInId() {
		return CheckInId;
	}
	public void setCheckInId(int checkInId) {
		CheckInId = checkInId;
	}
	public int getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(int SeatNo) {
		SeatNo = SeatNo;
	}
	public Bookings getBooking() {
		return booking;
	}
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	public CheckIn(@NotEmpty(message = "please review the washer, review can't be empty!") int checkInId,
			int SeatNo, Bookings booking) {
		super();
		CheckInId = checkInId;
		SeatNo = SeatNo;
		this.booking = booking;

	}
	@Override
	public String toString() {
		return "CheckInDetails[CheckInId=" + CheckInId+ ",SeatNo=" + SeatNo + ", booking=" + booking + "]";
	}
}

	