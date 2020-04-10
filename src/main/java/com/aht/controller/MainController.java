package com.aht.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.model.RolesFunctions;
import com.aht.model.RolesUsers;
import com.aht.service.RolesFunctionsService;
import com.aht.service.RolesUsersService;
import com.aht.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService uService;
	@Autowired
	private RolesUsersService ruService;
	@Autowired
	private RolesFunctionsService rfService;

	@RequestMapping(value = { "/", "/home" })
	public String home(HttpServletRequest request, Principal principal) {
		System.out.println(principal);
//		User loginUser = (User) ((Authentication)principal).getPrincipal();
		int userId = (uService.findByUserName(principal.getName())).getId();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		List<RolesUsers> listRUs = ruService.getListByUserId(userId);
		for (RolesUsers ru : listRUs) {
			List<RolesFunctions> RFs = rfService.getListByRoleId(ru.getRole().getId());
			for (RolesFunctions rf : RFs) {
				System.out.println("rf: " + rf.getFunction().getFunctionUrl());
			}
		}
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
