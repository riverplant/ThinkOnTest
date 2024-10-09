package com.example.ThinkOnDemo.service;

import java.util.List;
import java.util.Optional;

import com.example.ThinkOnDemo.domain.Users;

public interface UserService {

	public Users createUser(Users user);
	
	public List<Users> getAllUsers();
	
	public Optional<Users> getUserById(Long id);
	
	public Users updateUser(Long id, Users user);
	
	public void deleteUser(Long id);

	public List<Users> getAllAvailableUsers();
}
