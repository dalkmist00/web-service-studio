package com.studio.app.dynamo.model;

public class UserDTO {
	private String username;
	private String password;
	private String creationDate;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", creationDate=" + creationDate + "]";
	}	
}
