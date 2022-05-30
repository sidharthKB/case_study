package com.washerDetails.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washerDetails.model.CheckIn;



@Repository
public interface CheckInRepo extends MongoRepository<CheckIn,Integer> {
	
	public CheckIn findBy(int CheckInId);


}
