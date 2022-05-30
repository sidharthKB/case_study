package com.bookingdetails.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookingdetails.model.User;




@Repository
public interface UserRepository extends MongoRepository<User,Integer>{
	
	
	
    public User findByUsername(String username);
    
//  public User findByCustomerName(String name);
    
    public User deleteUserByusername(String username);

    
}
