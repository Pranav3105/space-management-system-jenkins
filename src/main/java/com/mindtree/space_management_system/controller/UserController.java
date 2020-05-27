/**
 * 
 */
package com.mindtree.space_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.space_management_system.dto.UserDto;
import com.mindtree.space_management_system.exceptions.ServiceException;
import com.mindtree.space_management_system.service.UserService;

/**
 * @author Pranav
 *
 */
@RestController
@RequestMapping(value="/usermanagement")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/user")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) throws ServiceException{
		UserDto savedUserDto = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(savedUserDto);
	}
	@GetMapping(value="/user")
	public ResponseEntity<UserDto> getUserById(@RequestParam("id") Long id) throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}
	@GetMapping(value="/users")
	public ResponseEntity<List<UserDto>> getAllUsers() throws ServiceException{
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
	}
	@PutMapping(value="/user")
	public UserDto updateUser(@RequestParam("id") Long userId, @RequestBody UserDto user) throws ServiceException {
		return userService.updateUserById(userId, user);
	}

}
