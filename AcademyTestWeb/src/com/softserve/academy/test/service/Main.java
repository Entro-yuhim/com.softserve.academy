package com.softserve.academy.test.service;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softserve.academy.test.DAO.CompetitionDAO;

public class Main {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("data.xml");
		System.out.println("something happened");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		CompetitionDAO cd = (CompetitionDAO) ac.getBean("CompetitionDAO");
		CompetitionService cs = (CompetitionService) ac.getBean("CompetitionService", CompetitionService.class);
		System.out.println(cs.retrieveAllCompetitions());
	}
}
