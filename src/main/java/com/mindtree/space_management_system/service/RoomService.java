package com.mindtree.space_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.space_management_system.dto.RoomDto;
import com.mindtree.space_management_system.exceptions.ServiceException;

@Service
public interface RoomService {

	public RoomDto addRooms(RoomDto rooms);
	
	public List<RoomDto> getAllRooms();
	
	public RoomDto getRoomById(Long id) throws ServiceException;
}
