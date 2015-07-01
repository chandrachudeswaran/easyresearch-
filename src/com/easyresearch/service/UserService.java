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
}
