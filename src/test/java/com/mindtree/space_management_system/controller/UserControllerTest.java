package com.mindtree.space_management_system.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mindtree.space_management_system.dto.BuildingDto;
import com.mindtree.space_management_system.dto.RoomDto;
import com.mindtree.space_management_system.dto.UserDto;
import com.mindtree.space_management_system.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	UserService userService;
	
	private UserDto userDto;
	
	@Before
	public void setup() {
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setBuildingName("Block B");
		RoomDto room = new RoomDto();
		room.setRoomNumber("4F206");
		room.setBuilding(buildingDto);
		userDto = new UserDto();
		userDto.setUserId(100L);
		userDto.setRoom(room);
		userDto.setUserName("Ramesh");
	}
	
	@Test
	public void getUserByIdTest() throws Exception {
		Mockito.when(userService.getUserById(100L)).thenReturn(userDto);
		mockMvc.perform(get("/usermanagement/user").param("id", "100").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
