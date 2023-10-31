package org.pojo;

public class User {
	private String role;

	public User() {
		setRole("guest");
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
