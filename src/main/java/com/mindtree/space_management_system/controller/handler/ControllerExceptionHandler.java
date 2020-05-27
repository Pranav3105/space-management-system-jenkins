package com.mindtree.space_management_system.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.space_management_system.controller.RoomController;
import com.mindtree.space_management_system.controller.UserController;
import com.mindtree.space_management_system.dto.ExceptionDto;
import com.mindtree.space_management_system.exceptions.ServiceException;

@RestControllerAdvice(assignableTypes= {RoomController.class,UserController.class})
public class ControllerExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionDto> serviceExceptionHandler(Exception e, Throwable cause){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
	}
}