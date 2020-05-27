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

import com.mindtree.space_management_system.dto.RoomDto;
import com.mindtree.space_management_system.exceptions.ServiceException;
import com.mindtree.space_management_system.service.RoomService;

/**
 * @author Pranav
 *
 */
@RestController
@RequestMapping(value = "/roommanagement")
public class RoomController {

	@Autowired
	RoomService roomService;

	@PostMapping(value = "/room")
	public RoomDto addRoom(@RequestBody RoomDto room) {
		return roomService.addRooms(room);
	}

	@GetMapping(value = "/rooms")
	public ResponseEntity<List<RoomDto>> getAllRooms() {
		return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());
	}

	@GetMapping(value = "room")
	public ResponseEntity<RoomDto> getRoomById(@RequestParam("id") Long roomId) throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomById(roomId));
	}
}
