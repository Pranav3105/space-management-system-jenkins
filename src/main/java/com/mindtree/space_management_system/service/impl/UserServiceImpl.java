package com.mindtree.space_management_system.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.mindtree.space_management_system.dto.UserDto;
import com.mindtree.space_management_system.entity.RoomEntity;
import com.mindtree.space_management_system.entity.UserEntity;
import com.mindtree.space_management_system.exceptions.ServiceException;
import com.mindtree.space_management_system.exceptions.util.ErrorConstants;
import com.mindtree.space_management_system.repository.RoomRepository;
import com.mindtree.space_management_system.repository.UserRepository;
import com.mindtree.space_management_system.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

	@Override
	public UserDto addUser(UserDto user) throws ServiceException {
		Optional<RoomEntity> roomEntity;
		roomEntity = roomRepository.findById(user.getRoom().getRoomId());
		roomEntity.orElseThrow(()->new ServiceException(ErrorConstants.NOSUCHROOM));
		UserEntity userEntity = convertDtoToEntity(user);
		userEntity.setRoom(roomEntity.get());
		return convertEntityToDto(userRepository.save(userEntity));
	}

	@Override
	public List<UserDto> getAllUser() throws ServiceException {
		List<UserEntity> userEntities = null;
		try {
		userEntities = userRepository.findAll();
		}
		catch (DataAccessException e) {
			throw new ServiceException(ErrorConstants.NOSUCHUSER);
		}
		return userEntities.stream().map(userEntity -> convertEntityToDto(userEntity)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Long id) throws ServiceException {
		Optional<UserEntity> userEntity = userRepository.findById(id);
		userEntity.orElseThrow(()->new ServiceException(ErrorConstants.NOSUCHUSER));
		return convertEntityToDto(userEntity.get());
	}

	@Override
	public UserDto updateUserById(Long id, UserDto userDto) {
		Optional<UserEntity> userEntityOptional = userRepository.findById(id);
		userEntityOptional.orElseThrow(()->new NoSuchElementException(ErrorConstants.NOSUCHUSER));
		Optional<RoomEntity> roomEntityOptional = roomRepository.findById(userDto.getRoom().getRoomId());
		roomEntityOptional.orElseThrow(()->new NoSuchElementException(ErrorConstants.NOSUCHROOM));
		userEntityOptional.get().setRoom(roomEntityOptional.get());
		UserEntity savedUserEntity = userRepository.save(userEntityOptional.get());
		return convertEntityToDto(savedUserEntity);
	}

	private UserDto convertEntityToDto(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserDto.class);
	}

	private UserEntity convertDtoToEntity(UserDto userDto) {
		return modelMapper.map(userDto, UserEntity.class);
	}

}
