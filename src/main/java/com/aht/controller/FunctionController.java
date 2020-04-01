package com.aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String showAdd() {
		return "/function/add";
	}

	@PostMapping(value = "/add")
	public String showAdd(@ModelAttribute("fun") Function fun, Model model) {
		return "redirect:/function/list";
	}
}
