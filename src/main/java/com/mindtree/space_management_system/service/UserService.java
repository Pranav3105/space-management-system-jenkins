package com.mindtree.space_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.space_management_system.dto.UserDto;
import com.mindtree.space_management_system.exceptions.ServiceException;

@Service
public interface UserService {
	
	public UserDto addUser(UserDto user) throws ServiceException;

	public List<UserDto> getAllUser() throws ServiceException;
	
	public UserDto getUserById(Long id)  throws ServiceException;
	
	public UserDto updateUserById(Long id, UserDto userDto)  throws ServiceException;
}
