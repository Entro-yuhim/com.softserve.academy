package com.softserve.academy.test.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;

public class HibernateUtil {
	private static SessionFactory factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			AnnotationConfiguration anf = new AnnotationConfiguration();
			anf.addAnnotatedClass(Competition.class);
			anf.addAnnotatedClass(Problem.class);
			anf.configure();
			return anf.buildSessionFactory();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static SessionFactory getSessionFactory(){
		return factory;
	}
	public static void shutdown(){
		factory.close();
	}

}
