package com.mindtree.space_management_system.service;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.space_management_system.dto.UserDto;
import com.mindtree.space_management_system.entity.BuildingEntity;
import com.mindtree.space_management_system.entity.RoomEntity;
import com.mindtree.space_management_system.entity.UserEntity;
import com.mindtree.space_management_system.exceptions.ServiceException;
import com.mindtree.space_management_system.repository.RoomRepository;
import com.mindtree.space_management_system.repository.UserRepository;
import com.mindtree.space_management_system.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@TestConfiguration
	static class UserServiceTestConfiguration {
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}

		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}
	}

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@MockBean
	RoomRepository roomRepository;

	@Autowired
	ModelMapper modelMapper;

	private UserEntity userEntity;
	private RoomEntity roomEntity;
	List<UserEntity> users;

	@Before
	public void setup() {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setBuildingName("Block A");
		roomEntity = new RoomEntity();
		roomEntity.setRoomId(100L);
		roomEntity.setBuilding(buildingEntity);
		users = new ArrayList<UserEntity>();
		userEntity = new UserEntity();
		userEntity.setUserName("Ramesh");
		userEntity.setUserId(101L);
		userEntity.setRoom(roomEntity);
		users.add(userEntity);
		roomEntity.setUsers(users);
	}

	@Test(expected=ServiceException.class)
	public void getAllUserExceptionTest() throws ServiceException {
		Mockito.when(userRepository.findAll()).thenThrow(DataRetrievalFailureException.class);
		userService.getAllUser();
	}
	
	@Test
	public void getAllUserSuccessTest() throws ServiceException {
		
		Mockito.when(userRepository.findAll()).thenReturn(users);
		assertEquals(users.size(), userService.getAllUser().size());
	}

	@Test
	public void addUserTest() throws ServiceException {
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		Optional<RoomEntity> room = Optional.of(roomEntity);
		Mockito.when(roomRepository.findById(userEntity.getRoom().getRoomId())).thenReturn(room);
		UserDto userDto = modelMapper.map(userEntity, UserDto.class);
		assertEquals(userDto.getRoom().getRoomId(), userService.addUser(userDto).getRoom().getRoomId());
	}
}
