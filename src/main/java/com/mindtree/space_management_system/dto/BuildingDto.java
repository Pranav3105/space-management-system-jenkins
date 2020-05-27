package com.mindtree.space_management_system.dto;

import java.io.Serializable;

public class BuildingDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long buildingId;
	private String buildingName;

	/**
	 * @return the buildingId
	 */
	public long getBuildingId() {
		return buildingId;
	}

	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(long buildingId) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (buildingId ^ (buildingId >>> 32));
		result = prime * result + ((buildingName == null) ? 0 : buildingName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		BuildingDto other = (BuildingDto) obj;
		if (buildingId != other.buildingId)
			return false;
		if (buildingName == null) {
			if (other.buildingName != null)
				return false;
		} else if (!buildingName.equals(other.buildingName)) {
			return false;
		}
			
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuildingDto [buildingId=" + buildingId + ", buildingName=" + buildingName + "]";
	}

}
