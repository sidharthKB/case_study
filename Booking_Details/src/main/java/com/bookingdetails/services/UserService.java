package com.bookingdetails.services;

import java.util.List;

import com.bookingdetails.model.User;

public interface UserService {
	
	//For Customer Details
	public List<User> getAllUser();
	
	public User getUserByusername(String username);
	
	

  public void setUser(User user);
	
	public User updateUserByusername(User user);
	
	public void deleteUserByusername(String username);
	
	public User findByusername(String username);

	User findByUserName(String username);


	
	

}
