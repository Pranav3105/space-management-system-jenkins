package com.mindtree.space_management_system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Pranav
 *
 */
@Entity
public class RoomEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	private String roomNumber;
	@ManyToOne(cascade=CascadeType.ALL)
	private BuildingEntity building;
	@OneToMany(mappedBy="room", cascade=CascadeType.ALL)
	private List<UserEntity> users = new ArrayList<>();
	/**
	 * @return the roomId
	 */
	public Long getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the building
	 */
	public BuildingEntity getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}
	/**
	 * @return the users
	 */
	public List<UserEntity> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoomEntity [roomId=" + roomId + ", roomNumber=" + roomNumber + ", building=" + building + "]";
	}
	
	
	
}
