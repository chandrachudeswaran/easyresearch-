package com.easyresearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
