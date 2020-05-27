package com.mindtree.space_management_system.repository;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.space_management_system.entity.BuildingEntity;
import com.mindtree.space_management_system.entity.RoomEntity;
import com.mindtree.space_management_system.entity.UserEntity;
import com.mindtree.space_management_system.repository.UserRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	UserRepository userRepository;
	
	private UserEntity userEntity;
	
	@Test
	public void getUserTest() {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setBuildingName("Block A");
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setBuilding(buildingEntity);
		List<UserEntity> users = new ArrayList<UserEntity>();
		userEntity = new UserEntity();
		userEntity.setUserName("Ramesh");
		userEntity.setRoom(roomEntity);
		users.add(userEntity);
		roomEntity.setUsers(users);
		testEntityManager.persist(roomEntity);
		testEntityManager.persist(userEntity);
		assertThat(userRepository.findAll(), contains(hasProperty("userName", is(userEntity.getUserName()))));
	}

}
