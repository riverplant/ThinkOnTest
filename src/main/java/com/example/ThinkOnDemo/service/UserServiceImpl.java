package com.example.ThinkOnDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.ThinkOnDemo.domain.Users;
import com.example.ThinkOnDemo.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository  userRepository;
	
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(Users user) {
    	Optional<Users> existingUser = userRepository.findByPhoneNumberAndEmail(user.getPhoneNumber(), user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this phone number and email already exists.");
        }
        return userRepository.save(user);
    }
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users updateUser(Long id, Users userDetails) {
        Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setAvailable(userDetails.isAvailable());
        return userRepository.save(user);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Long id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Users> getAllAvailableUsers() {
		return userRepository.findByAvailable(Boolean.TRUE);
	}
}
