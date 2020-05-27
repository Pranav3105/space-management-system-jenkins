/**
 * 
 */
package com.mindtree.space_management_system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Pranav
 *
 */
public class RoomDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long roomId;
	private String roomNumber;
	private BuildingDto building;
	@JsonIgnoreProperties("room")
	private List<UserDto> users = new ArrayList<>();
	/**
	 * @return the roomId
	 */
	public long getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(long roomId) {
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
	public BuildingDto getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(BuildingDto building) {
		this.building = building;
	}
	/**
	 * @return the users
	 */
	public List<UserDto> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + (int) (roomId ^ (roomId >>> 32));
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomDto other = (RoomDto) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (roomId != other.roomId)
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", roomNumber=" + roomNumber + ", building=" + building + "]";
	}
	
	
}
