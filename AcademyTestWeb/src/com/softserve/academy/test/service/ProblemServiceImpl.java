package com.softserve.academy.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.test.DAO.ProblemDAO;
import com.softserve.academy.test.DAO.HibernateUtil;
import com.softserve.academy.test.DAO.ProblemHBN;
import com.softserve.academy.test.model.entity.Problem;

@Service("ProblemService")
public class ProblemServiceImpl implements ProblemService {
	private ProblemServiceImpl() {
	}

	private static ProblemServiceImpl Instance;

	public static ProblemServiceImpl getInstance() {
		if (Instance == null) {
			Instance = new ProblemServiceImpl();
		}
		return Instance;
	}

	@Autowired
	private ProblemDAO problemDAO;

	/*
	 * private static ProblemDAO atp = ProblemHBN
	 * .getInstance(HibernateUtil.getSessionFactory());
	 */
	@Transactional
	@Override
	public List<Problem> retrieveAllProblems() {

		return problemDAO.retrieveAllProblems();
	}

	@Transactional
	@Override
	public void createProblem(Problem p) {
		problemDAO.createProblem(p);
	}

	@Transactional
	@Override
	public void updateProblem(Problem p) {
		problemDAO.updateProblem(p);
	}

	@Transactional
	@Override
	public Problem retrieveProblem(int id) {
		return problemDAO.retrieveProblem(id);
	}

	@Transactional
	@Override
	public void deleteProblem(int id) {
		problemDAO.deleteProblem(id);
	}

}
