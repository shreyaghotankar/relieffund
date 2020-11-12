package com.charity.relieffund.dto;

import java.io.Serializable;

public class UserProfileInfoDTO implements Serializable {
	
	private static final long serialVersionUID = -1;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	
	
	public UserProfileInfoDTO() {
		super();
	}
	
	public UserProfileInfoDTO(String userName, String firstName, String lastName, String email){
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
