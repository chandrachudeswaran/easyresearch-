package com.easyresearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyresearch.dao.Users;
import com.easyresearch.dao.UsersDao;

@Service
public class UserService {
	
	@Autowired
	private UsersDao usersdao;
	
	
	public Users getUser(int id){
		
		return usersdao.getUser(id);
	}
	
	public boolean createUser(Users user){
		return usersdao.createUser(user);
	}

	public boolean existsUsername(String username) {
		return usersdao.existsUsername(username);
	}

	public boolean existsEmail(String email) {
		return usersdao.existsEmail(email);
	}

	
}
