package com.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Flight_Details;



@Repository
public interface FlightRepository extends MongoRepository<Flight_Details, Integer> {

	public Flight_Details findByflightId(int id);

	public Flight_Details findByflightName(String name);

}
