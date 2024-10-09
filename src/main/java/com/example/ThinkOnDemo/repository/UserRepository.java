package com.example.ThinkOnDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ThinkOnDemo.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	 List<Users> findByAvailable(Boolean available);

	 @Query("from Users u where u.phoneNumber = ?1 and u.email = ?2")
	 Optional<Users> findByPhoneNumberAndEmail(String phoneNumber, String email);
}
