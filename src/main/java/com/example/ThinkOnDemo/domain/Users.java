package com.example.ThinkOnDemo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "sys_user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", length = 64, nullable = false)
	private String username;

	@Column(name = "first_name", length = 64, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 64, nullable = false)
	private String lastName;

	@Email(message = "Email is not valid")
	@Column(name = "email", length = 64, nullable = false)
	private String email;

	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	@Column(name = "phone_number", length = 32, nullable = false)
	private String phoneNumber;

	@Column(name = "is_available", nullable = false)
	private boolean available = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean isAvailable) {
		this.available = isAvailable;
	}
	
	public Users username( String username ) {
		this.setUsername(username);
		return this;
	}
	
	public Users firstName( String firstName ) {
		this.setFirstName(firstName);
		return this;
	}
	
	public Users lastName( String lastName ) {
		this.setLastName(lastName);
		return this;
	}
	
	public Users email( String email ) {
		this.setEmail(email);
		return this;
	}
	
	public Users phoneNumber( String phoneNumber ) {
		this.setPhoneNumber(phoneNumber);
		return this;
	}
	
	public Users isAvailable( boolean isAvailable ) {
		this.setAvailable(isAvailable);
		return this;
	}

}
