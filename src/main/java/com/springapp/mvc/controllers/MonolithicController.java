package com.springapp.mvc.controllers;

import com.springapp.mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MonolithicController {

	// TODO Authentication/session variables
	// TODO Database access

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome to Charit-E-Bay!");
		return "hello"; // This is the path of the template file
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String login(@ModelAttribute("User") User user) {
		if(user.authenticate()) {

			// TODO be logged in
		} else {
			// TODO reject login
		}
		return "hello";
	}



//	@RequestMapping("/new_account")
//	public String newAccount(ModelMap model) {
//		model.addAttribute("message", "Login Failed!");
//		User temp = new User("test@example.com");
//		return "hello";
//	}
}