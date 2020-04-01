package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService uService;

	@RequestMapping(value = { "/" })
	public String helloWorld() {
		return "home";
	}

	@RequestMapping(value = { "/login" })
	public String loginForm(Model model) {
		return "login";
	}

	@RequestMapping(value = { "/errorPage" })
	public String errorPage() {
		return "403";
	}

	@RequestMapping(value = { "/logout" })
	public String logout() {
		return "redirect:/login";
	}

	@RequestMapping(value = { "/test" })
	public String test() {
		return "test";
	}
//	@Autowired
//	UserRepository ur;

//	@GetMapping(value = "/user")
//	public ResponseEntity<User> getUserByName(@RequestParam(value = "name") String name) {
//		return ResponseEntity.ok(ur.findByName(name));
//	}
}
