package com.easyresearch.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String doLogin() {
		return "login";
	}

	@RequestMapping("/registration")
	public String doRegistration(Model model) {

		model.addAttribute("users", new Users());

		return "registration";
	}

	@RequestMapping(value = "/doRegistration", method = RequestMethod.POST)
	public String registration(Model model, @Valid Users user,BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		}

		user.setEnabled(true);
		user.setAuthority("ROLE_AUTHOR");
		
		if(userservice.existsUsername(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username");
			return "registration";
		}
		
		if(userservice.existsEmail(user.getEmail())){
			result.rejectValue("email", "DuplicateKey.user.email");
			return "registration";
		}
		
		userservice.createUser(user);
		return "success";
	}

	@RequestMapping("/success")
	public String showSuccess() {
		return "success";
	}

	@RequestMapping("/logout")
	public String doLogout() {
		return "home";
	}
	
	
}
