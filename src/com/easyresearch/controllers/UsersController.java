package com.easyresearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easyresearch.dao.Address;
import com.easyresearch.dao.Users;
import com.easyresearch.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userservice;

	@RequestMapping("/users")
	public String displayUsers(Model model) {
		
		Users user = userservice.getUser(1);
		model.addAttribute("user", user);
		return "showusers";
	}
	
	@RequestMapping("/login")
	public String doLogin(){
		return "login";
	}
	
	@RequestMapping("/registration")
	public String doRegistration(){
		System.out.println("hello");
		//Users user = new Users();
		//model.addAttribute("user", user);
		return "registration";
	}
	
	@RequestMapping(value="/doRegistration", method=RequestMethod.POST)
	public String registration(Model model,Users user,Address address){
	
		user.setAddress(address);
		user.setEnabled(true);
		
		userservice.createUser(user);
	return "registrationsuccess";
	}
	
	
	
	@RequestMapping("/success")
	public String showSuccess(){
		return "success";
	}
}
