package com.mindtree.space_management_system.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.space_management_system.dto.RoomDto;
import com.mindtree.space_management_system.entity.BuildingEntity;
import com.mindtree.space_management_system.entity.RoomEntity;
import com.mindtree.space_management_system.exceptions.ServiceException;
import com.mindtree.space_management_system.exceptions.util.ErrorConstants;
import com.mindtree.space_management_system.repository.BuildingRepository;
import com.mindtree.space_management_system.repository.RoomRepository;
import com.mindtree.space_management_system.service.RoomService;

@Component
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	BuildingRepository buildingRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public RoomDto addRooms(RoomDto room) {
		RoomEntity roomEntity = convertDtoToEntity(room);
		Optional<BuildingEntity> buildingEntity = buildingRepository.getBuildingByBuildingName(room.getBuilding().getBuildingName());
		if(buildingEntity.isPresent()) {
			roomEntity.setBuilding(buildingEntity.get());
		}
		roomEntity.getUsers().forEach(entity->entity.setRoom(roomEntity));
		RoomEntity savedRoomEntity = roomRepository.save(roomEntity);
		return convertEntityToDto(savedRoomEntity);
	}

	@Override
	public List<RoomDto> getAllRooms() {
		List<RoomEntity> roomEntities = roomRepository.findAll();
		List<RoomDto> rooms =  roomEntities.stream().map(entity->convertEntityToDto(entity)).collect(Collectors.toList());
		return rooms;
	}

	@Override
	public RoomDto getRoomById(Long id) throws ServiceException {
		Optional<RoomEntity> roomEntityOptional = roomRepository.findById(id);
		roomEntityOptional.orElseThrow(()->new ServiceException(ErrorConstants.NOSUCHROOM));
		return convertEntityToDto(roomEntityOptional.get());
	}
	
	private RoomDto convertEntityToDto(RoomEntity roomEntity) {
		return modelMapper.map(roomEntity, RoomDto.class);
	}
	private RoomEntity convertDtoToEntity(RoomDto roomDto) {
		return modelMapper.map(roomDto, RoomEntity.class);
	}

}
