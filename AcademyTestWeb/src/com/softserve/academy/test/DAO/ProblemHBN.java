package com.softserve.academy.test.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.test.model.entity.Problem;

@Repository
public class ProblemHBN implements ProblemDAO {
	@Autowired
	private SessionFactory sf;

	private static ProblemHBN Instance;

	private ProblemHBN() {
	}

//	public static ProblemHBN getInstance(SessionFactory sessionfact) {
//		if (Instance == null) {
//			Instance = new ProblemHBN();
//		}
//		this.sf = sessionfact;
//		return Instance;
//
//	}

	@Transactional
	public void createProblem(Problem problem) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(problem);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public Problem retrieveProblem(int id) {
		Session session = sf.openSession();
		Problem problem = (Problem) session.get(Problem.class, id);
		session.close();
		return problem;
	}

	@Transactional
	public void updateProblem(Problem p) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public void deleteProblem(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		String sqlq1 = "delete from CompetitionUtil where (ProblemId) in (select problemId from problems where problemId= :id);";
		String sqlq = "Delete from academytesthibernate.problems where problemId = :id";
		Query query = session.createSQLQuery(sqlq);
		Query query1 = session.createSQLQuery(sqlq1);
		query1.setParameter("id", id);
		query.setParameter("id", new Integer(id));
		query1.executeUpdate();
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public List<Problem> retrieveAllProblems() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Problem> result = session.createCriteria(Problem.class).list();
		session.close();
		return null;
	}

}
