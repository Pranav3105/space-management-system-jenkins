package com.mindtree.space_management_system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Pranav
 *
 */
@Entity
public class BuildingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long buildingId;
	private String buildingName;
	@OneToMany(mappedBy="building")
	private List<RoomEntity> rooms;
	/**
	 * @return the buildingId
	 */
	public Long getBuildingId() {
		return buildingId;
	}
	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}
	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	/**
	 * @return the rooms
	 */
	public List<RoomEntity> getRooms() {
		return rooms;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<RoomEntity> rooms) {
		this.rooms = rooms;
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
		return "BuildingEntity [buildingId=" + buildingId + ", buildingName=" + buildingName + "]";
	}
	
	
	
	
	
	
}
