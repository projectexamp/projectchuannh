package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.model.Function;
import com.aht.model.Role;
import com.aht.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = { "/list" })
	public String getAll(Model model) {
		model.addAttribute("list", roleService.getAll());

		return "/role/listRoles";
	}

	@GetMapping(value = "/add")
	public String doAdd(Model model) {
		model.addAttribute("role", new Role());
		return "role/add";
	}

	@PostMapping(value = "/add")
	public String doAdd(@ModelAttribute("role") Role role) {
		roleService.createRole(role);
		return "redirect:/role/list";
	}

	@GetMapping(value = "/update/{id}")
	public String doUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("oldRole", roleService.getById(id));
		return "role/update";
	}

	@PostMapping(value = "/update")
	public String doUpdate(@ModelAttribute("oldRole") Role role) {
		roleService.updateRole(role);
		return "redirect:/role/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteRole(@PathVariable("id") int id) {
		roleService.deleteRole(id);

		return "redirect:/role/list";
	}

	@GetMapping(value = "/disable/{id}")
	public String disableRole(@PathVariable("id") int id) {
		roleService.disableRole(id);

		return "redirect:/role/list";
	}

	@GetMapping(value = "/active/{id}")
	public String activeRole(@PathVariable("id") int id) {
		roleService.activeRole(id);

		return "redirect:/role/list";
	}
}
