package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.model.Users;
import com.aht.service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private UserService uService;

	@RequestMapping(value = { "/register" })
	public String showForm(Model model) {
		model.addAttribute("newUser", new Users());
		return "user/register";
	}

	@PostMapping(value = { "/signUp" })
	public String register(@ModelAttribute("newUser") Users user) {
		uService.createUser(user);
		uService.autoLogin(user.getUsername(), user.getPassword());
		return "redirect:/";
	}

	@RequestMapping(value = { "/changePw" })
	public String changePw(@ModelAttribute("user") Users user, Model model) {
		return "user/changePassword";
	}
}
