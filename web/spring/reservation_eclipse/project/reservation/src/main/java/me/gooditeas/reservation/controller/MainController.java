package me.gooditeas.reservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import me.gooditeas.reservation.service.PromotionService;

@Controller
public class MainController {
	
	@Autowired
	PromotionService pService;
	
	@GetMapping("")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("promotionItems", pService.getPromotionsInfo().get("items"));
		
		return "mainpage";
	}
}
