package com.aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.model.Function;
import com.aht.service.FunctionService;

@Controller
@RequestMapping(value = { "/function" })
public class FunctionController {
	@Autowired
	private FunctionService fService;

	@RequestMapping(value = "/list")
	public String getAll(Model model) {
		List<Function> page = fService.getAll();
		model.addAttribute("list", page);
		return "/function/listFunction";
	}

	@GetMapping(value = "/add")
	public String doAdd(Model model) {
		model.addAttribute("fun", new Function());
		return "/function/add";
	}

	@PostMapping(value = "/add")
	public String doAdd(@ModelAttribute("fun") Function fun) {
		if (fun != null) {
			fService.createFunction(fun);
		}
		return "redirect:/function/list";
	}

	@GetMapping(value = "/update/{id}")
	public String doUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("oldFn", fService.getById(id));
		return "function/update";
	}

	@PostMapping(value = "/update")
	public String doUpdate(@ModelAttribute("oldFn") Function fn) {
		fService.updateFunction(fn);
		return "redirect:/function/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteFunc(@PathVariable("id") int id) {
		fService.deleteFunction(id);
		return "redirect:/function/list";
	}

	@GetMapping(value = "/disable/{id}")
	public String disableFunc(@PathVariable("id") int id) {
		fService.disableFunc(id);
		return "redirect:/function/list";
	}

	@GetMapping(value = "/active/{id}")
	public String activeFunc(@PathVariable("id") int id) {
		fService.activeFunc(id);
		return "redirect:/function/list";
	}
}