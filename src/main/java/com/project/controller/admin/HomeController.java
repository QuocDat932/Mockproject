package com.project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.services.StatsServices;

@Controller(value = "controllerOfAdmin")
@RequestMapping("/admin")
public class HomeController {
	@Autowired
	private StatsServices statsService;
	@GetMapping("")
	public String doGetIndex(Model model) {
		String[][] statsTotalPriceLast6Month = statsService.getTotalPrice6Months();
		model.addAttribute("stats", statsTotalPriceLast6Month);
		return "admin/index";
	}
}