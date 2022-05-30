package com.bookingdetails.services;

//import java.security.SecureRandom;
//import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingdetails.exceptions.CustomerNotFoundException;
import com.bookingdetails.model.User;
import com.bookingdetails.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserByusername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public void setUser(User user) {
		userRepository.save(user);		
	}

	@Override
	public User updateUserByusername(User user) {
	
		return userRepository.save(user);
	}

	@Override
	public void deleteUserByusername(String username) {
		userRepository.deleteUserByusername(username);
		
	}


	@Override
	public User findByUserName(String username) {
		User user = userRepository.findAll().stream()
				.filter(a -> a.getUsername().equalsIgnoreCase(username)).findAny().orElseThrow(null);
		if (user == null) {

			throw new CustomerNotFoundException(
					"Customer with the provided name is not found, please use the name which was used at the time of registration!");

		} else {
			return user;
		}
	}

	public Object addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

		// TODO Auto-generated method stub
		public User findByusername(String username) {
			User user = userRepository
	                .findAll()
	                .stream()
	                .filter(a -> a.getUsername().equalsIgnoreCase(username))
	                .findAny().orElse(null);
			if (user == null) {
				throw new CustomerNotFoundException("Sorry, User with the provided Username not found" +
						",Please provide the correct Username");
			}
			else {
				return userRepository.findByUsername(username);
			}
		}

	}
		
		



	
	
	
