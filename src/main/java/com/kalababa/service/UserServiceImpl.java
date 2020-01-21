package com.kalababa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kalababa.model.User;
import com.kalababa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Transactional
	public List<User> getAllUsers() {
	return userRepo.findAll();
	}

	@Transactional
	public void deleteUser(String userId) {
		userRepo.deleteById(userId);
	}
	@Transactional 
	public void addUser(User user){
		userRepo.save(user);
	}
	
	public User getUserById(String userId) {
		return userRepo.findById(userId).get();
	}

	
}
