package com.softserve.academy.test.model.hibernate;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Session;

import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;

public class CompetHiber {
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Competition c = createComp();
		session.save(c);
		session.close();
		HibernateUtil.shutDown();
	}
	
	
	public static Competition createComp() {
	Problem p1 = new Problem("Easy", "Problem 1", "Easy Problem");
	Problem p2 = new Problem("Medium", "Problem 2", "Medium Problem");
	Problem p3 = new Problem("Hard", "Problem 3", "Hard Problem");
	ArrayList<Problem> ps = new ArrayList<Problem>();
	ps.add(p1);
	ps.add(p2);
	ps.add(p3);
	Competition c = new Competition();
	c.setId(15);
	try {
		DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
		Date startDate = df.parse("11 20 25 10 2015");
		c.setStartTime(startDate);

		Date endDate = df.parse("12 30 31 11 2015");
		c.setEndTime(endDate);

	} catch (Exception ex) {
	}
	c.setAllProblems(ps);
	return c;
}
}
