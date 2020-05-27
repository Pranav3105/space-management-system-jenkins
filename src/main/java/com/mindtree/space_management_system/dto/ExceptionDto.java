package com.mindtree.space_management_system.dto;

public class ExceptionDto {
	
	private String message;
	/**
	 * 
	 */
	public ExceptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public ExceptionDto(String message, Throwable cause) {
		super();
		this.message = message;
	}
	public ExceptionDto(String message) {
		this.message=message;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
