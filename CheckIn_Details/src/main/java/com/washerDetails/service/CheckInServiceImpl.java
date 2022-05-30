package com.washerDetails.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.washerDetails.Repo.CheckInRepo;
import com.washerDetails.model.CheckIn;


@Service
public class CheckInServiceImpl implements CheckInService {

	@Autowired
	private CheckInRepo repo;
	@Override
	public List<CheckIn> getAllCheckIn() {
		return repo.findAll();
	}

	@Override
	public CheckIn getCheckInByCheckInId(int CheckInId) {
		
		 return repo.findBy(CheckInId);
	}


	@Override
	public void setCheckIn(CheckIn checkIn) {
		Random random=new Random();
		checkIn.setCheckInId(random.nextInt(9999));
		checkIn.setSeatNo(random.nextInt(9999));
		repo.save(checkIn);
		
	}



}
