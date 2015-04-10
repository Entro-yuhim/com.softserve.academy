package com.softserve.academy.test.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.academy.test.service.CompetitionService;

@Controller
@RequestMapping("/")
public class HomeController {
//	@Autowired
//	CompetitionService competitionService;
	@RequestMapping("/")
	public String home(){
		System.out.println("HomeController");
		return "redirect:/index";
	}
	@RequestMapping(value="/GetCompetitions/", method=RequestMethod.GET)
	public String doSomethingPlease(@ModelAttribute("text") String test){
		System.out.println("HomeController");
		System.out.println(test);
		return null;
	}

}
