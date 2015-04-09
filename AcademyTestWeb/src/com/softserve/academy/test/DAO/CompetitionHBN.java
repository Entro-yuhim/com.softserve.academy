package com.softserve.academy.test.DAO;

//import java.util.Date;
import java.util.List;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;

@Repository("CompetitionDAO")
public class CompetitionHBN implements CompetitionDAO {
	private static CompetitionHBN Instance;

	@Autowired
	private SessionFactory sf;

	private CompetitionHBN() {
	}
	
//	
//	public static CompetitionHBN getInstance(SessionFactory sessionfact) {
//		if (Instance == null) {
//			Instance = new CompetitionHBN();
//		}
//		sf = sessionfact;
//		return Instance;
//	}

	@Transactional
	public Competition retrieveCompetition(int id) {
		Session session = sf.openSession();
		Competition competition = (Competition) session.get(Competition.class,
				id);
		session.close();
		return competition;
	}

	@Transactional
	public void createCompetition(Competition c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public void updateCompetition(Competition c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public void deleteCompetition(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		String sqlq = "Delete from Competition where competitionId = :id";
		Query query = session.createQuery(sqlq);
		query.setParameter("id", new Integer(id));
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public List<Competition> retrieveAllCompetitions() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Competition> result = session.createCriteria(Competition.class)
				.list();
		session.close();
		return result;
	}

}
