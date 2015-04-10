package com.softserve.academy.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/GetCompetitions/")
public class CompetitionList {
	@RequestMapping(value="/{text}", method = RequestMethod.POST)
	public String getCompetitions(@PathVariable("text") String test){
		System.out.println("CompetitionList");
		System.out.println(test);
		return "CompetitionList";
	}
}
