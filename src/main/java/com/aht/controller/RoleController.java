package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.model.Function;
import com.aht.model.Role;
import com.aht.model.RolesFunctions;
import com.aht.service.FunctionService;
import com.aht.service.RoleService;
import com.aht.service.RolesFunctionsService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private FunctionService funcService;
	@Autowired
	private RolesFunctionsService rfService;

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

//	@GetMapping(value = "/assignRole/{id}")
//	public String showAssignForm(Model model, @PathVariable("id") int id) {
//		model.addAttribute("rf", new RolesFunctions());
//		model.addAttribute("list", funcService.getAll());
//		model.addAttribute("role", roleService.getById(id));
//		return "role/assignFunc";
//	}
//
//	@PostMapping(value = "/assignFnToRole")
//	public String assginFnToRole(@ModelAttribute RolesFunctions rf) {
//		System.out.println("getFunc: " + rf.getFunction());
//		System.out.println("getRole: " + rf.getRole());
//		System.out.println("rd: " + rf);
//		return "redirect:/role/list";
//	}

	@GetMapping(value = "/assignFunc/{id}")
	public String showAssignForm(Model model, @PathVariable("id") int id) {
		Role role = roleService.getById(id);
		RolesFunctions rf = new RolesFunctions();
		rf.setRole(role);
		model.addAttribute("rf", rf);
		model.addAttribute("list", funcService.getAll());
		return "role/assignFunc";
	}

	@PostMapping(value = "/assignFnToRole")
	public String assginFnToRole(@RequestParam("functionId") Integer[] arrFunctionId,
			@ModelAttribute("rf") RolesFunctions rf) {
		for (Integer tmp : arrFunctionId) {
			Function function = funcService.getById(tmp);
			rfService.create(new RolesFunctions(true, rf.getRole(), function));
		}
		return "redirect:/role/list";
	}

	@PostMapping(value = "/search")
	public String searchRole(@RequestParam("searchTxt") String roleName, Model model) {
		if (roleName == null || ("").equals(roleName)) {
			model.addAttribute("list", roleService.getAll());
		} else {
			model.addAttribute("list", roleService.searchRole(roleName));
		}
		return "/role/listRoles";
	}
}
