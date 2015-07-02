package com.easyresearch.dao;

public class Users {
	
	private String username;
	private String password;
	private int id;
	private String email;
	private Address address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", id=" + id + ", email=" + email + ", address=" + address
				+ "]";
	}
	public Users(String username, String password, int id, String email,
			Address address) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.email = email;
		this.address = address;
	}
	
	public Users(){
		
	}
	
	

}
