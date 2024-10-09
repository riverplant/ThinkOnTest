package com.example.ThinkOnDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ThinkOnDemo.domain.Users;
import com.example.ThinkOnDemo.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class ThinkOnDemoApplicationTests{

	@Autowired
	private UserService userService;

	@Test
	void getUser_whenSaved_thenCanBeFoundById() {
		Users user = new Users().username("testuser").firstName("jie").lastName("Li").email("tester@gmail.com")
				.phoneNumber("5500411212").isAvailable(true);

		userService.createUser(user);
		assertNotNull(user.getId());
		Optional<Users> userOptional = userService.getUserById(user.getId());
		Users userNew = userOptional.get();
		assertNotNull(userNew);
	    assertEquals(userNew.getId(), user.getId());
	    
	    userNew.setEmail("tester2@gmail.com");
	    userNew.setPhoneNumber("5500411220");
	    userService.updateUser(userNew.getId(), userNew);
	    
	    Optional<Users> userUpdatedOptional = userService.getUserById(user.getId());
	    Users userUpdatedUsers = userUpdatedOptional.get();
	    assertNotNull(userUpdatedUsers);
	    assertEquals("tester2@gmail.com", userUpdatedUsers.getEmail());
	    userService.deleteUser(user.getId());

	}
	
	
	@Test
	void testUserDelete() {
		Users user1 = new Users().username("testuser04").firstName("jie").lastName("Li").email("tester04@gmail.com")
				.phoneNumber("5500411213").isAvailable(true);
		Users user2 = new Users().username("testuser02").firstName("pierre").lastName("Goden").email("tester02@gmail.com")
				.phoneNumber("5500411211").isAvailable(false);
		Users user3 = new Users().username("testuser03").firstName("Laurent").lastName("Ident").email("tester03@gmail.com")
				.phoneNumber("5500411212").isAvailable(true);

		userService.createUser(user1);
		userService.createUser(user2);
		userService.createUser(user3);

		assertNotNull(userService.getUserById(user1.getId()));
		assertNotNull(userService.getUserById(user2.getId()));
		assertNotNull(userService.getUserById(user3.getId()));
		
		userService.deleteUser(user1.getId());
		assertEquals(userService.getUserById(user1.getId()).isEmpty(), true);
	    
	    userService.deleteUser(user2.getId());
	    assertEquals(userService.getUserById(user2.getId()).isEmpty(), true);
	    userService.deleteUser(user3.getId());
	    assertEquals(userService.getUserById(user3.getId()).isEmpty(), true);
	    

	}
	
}
