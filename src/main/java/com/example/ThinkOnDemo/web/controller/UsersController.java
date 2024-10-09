package com.example.ThinkOnDemo.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ThinkOnDemo.domain.Users;
import com.example.ThinkOnDemo.domain.support.JsonResult;
import com.example.ThinkOnDemo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping
	public JsonResult getAllUsers() {
		return new JsonResult().status(HttpStatus.OK.value()).data(userService.getAllUsers());
	}
	
	@GetMapping("/available")
	public JsonResult getAllAvailableUsers() {
		return new JsonResult().status(HttpStatus.OK.value()).data(userService.getAllAvailableUsers());
	}

	@GetMapping("/{id}")
	public JsonResult getUserById(@PathVariable Long id) {
		Optional<Users>  userOptional= userService.getUserById(id);
		return userOptional.isPresent() ? 
				new JsonResult().status(HttpStatus.OK.value()).data(userOptional.get()) :
					new JsonResult().status(HttpStatus.NO_CONTENT.value()).data(null)	;
	}

	@PostMapping
	public JsonResult createUser(@Valid @RequestBody Users user, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return new JsonResult().status(HttpStatus.BAD_REQUEST.value()).data(errors);
		}

		user.setAvailable(true);
		userService.createUser(user);
		return new JsonResult().status(HttpStatus.CREATED.value()).data(user);
	}

	@PutMapping("/{id}")
	public JsonResult updateUser(@PathVariable Long id, @Valid @RequestBody Users user, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return new JsonResult().status(HttpStatus.BAD_REQUEST.value()).data(errors);
		}
		userService.updateUser(id, user);
		return new JsonResult().status(HttpStatus.OK.value()).data(user);
	}

	@DeleteMapping("/{id}")
	public JsonResult deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return JsonResult.ok();
	}
}
