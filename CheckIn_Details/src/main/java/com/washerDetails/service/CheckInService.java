package com.washerDetails.service;

import java.util.List;

import com.washerDetails.model.CheckIn;





public interface CheckInService 
{
public List<CheckIn> getAllCheckIn();
	
	public CheckIn getCheckInByCheckInId(int CheckInId);
	

	
	public void setCheckIn(CheckIn checkIn);
}

