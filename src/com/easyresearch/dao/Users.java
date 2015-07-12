package com.easyresearch.dao;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Users {
	
	@NotBlank
	@Size(min=5,max=55)
	private String username;
	
	@NotBlank
	@Size(min=5,max=60)
	private String password;
	
	private int id;
	
	@NotBlank
	@Size(min=5,max=65)
	private String email;
	
	private boolean enabled;
	
	@NotBlank
	@Size(min=5,max=45)
	private String city;
	
	@NotBlank
	@Size(min=2,max=35)
	private String country;
	
	
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public Users(String username, String password, int id, String email,
			boolean enabled, String city, String country) {
	
		this.username = username;
		this.password = password;
		this.id = id;
		this.email = email;
		this.enabled = enabled;
		this.city = city;
		this.country = country;
	}
	
	
	@Override
	public String toString() {
		return "Users [username=" + username + ", id=" + id + ", email="
				+ email + ", enabled=" + enabled + ", city=" + city
				+ ", country=" + country + "]";
	}
	
	
	public Users(){
		
	}
	
	

}
