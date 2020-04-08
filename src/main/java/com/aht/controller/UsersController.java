package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.model.Role;
import com.aht.model.RolesUsers;
import com.aht.model.Users;
import com.aht.service.RoleService;
import com.aht.service.RolesUsersService;
import com.aht.service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private UserService uService;
	@Autowired
	private RoleService rService;
	@Autowired
	private RolesUsersService ruSerive;

	@RequestMapping(value = { "/register" })
	public String showForm(Model model) {
		model.addAttribute("newUser", new Users());
		return "user/register";
	}

	@PostMapping(value = { "/signUp" })
	public String register(@ModelAttribute("newUser") Users user) {
		uService.createAccount(user);
//		uService.autoLogin(user.getUsername(), user.getPassword());
		return "redirect:/";
	}

	@RequestMapping(value = { "/changePw" })
	public String changePw(@ModelAttribute("user") Users user, Model model) {
		return "user/changePassword";
	}

	@RequestMapping(value = "/list")
	public String getAll(Model model) {
		model.addAttribute("list", uService.getAll());
		return "user/listUsers";
	}

	@GetMapping(value = "/add")
	public String doAdd(Model model) {
		model.addAttribute("user", new Users());
		return "user/add";
	}

	@PostMapping(value = "/add")
	public String doAdd(@ModelAttribute("user") Users user) {
		uService.createUser(user);
		return "redirect:/user/list";
	}

	@GetMapping(value = "/update/{id}")
	public String doUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("oldUser", uService.getById(id));
		return "user/update";
	}

	@PostMapping(value = "/update")
	public String doUpdate(@ModelAttribute("oldUser") Users user) {
		uService.updateUser(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String doDelete(@PathVariable("id") int id) {
		uService.deleteUser(id);
		return "redirect:/user/list";
	}

	@GetMapping(value = "/disable/{id}")
	public String disableUser(@PathVariable("id") int id) {
		uService.disableUser(id);
		return "redirect:/user/list";
	}

	@GetMapping(value = "/active/{id}")
	public String activeUser(@PathVariable("id") int id) {
		uService.activeUser(id);
		return "redirect:/user/list";
	}

	@GetMapping(value = "/assignRole/{id}")
	public String showAssignForm(Model model, @PathVariable("id") int id) {
		Users user = uService.getById(id);
		RolesUsers ru = new RolesUsers();
		ru.setUser(user);
		model.addAttribute("ru", ru);
		model.addAttribute("list", rService.getAll());
		return "user/assignRole";
	}

	@PostMapping(value = "/assignRoleToUser")
	public String assginRoleToUser(@RequestParam("roleId") Integer[] arrRoleId, @ModelAttribute("ru") RolesUsers ru) {
		for (Integer tmp : arrRoleId) {
			Role role = rService.getById(tmp);
			ruSerive.create(new RolesUsers(true, ru.getUser(), role));
		}
		return "redirect:/user/list";
	}
}
