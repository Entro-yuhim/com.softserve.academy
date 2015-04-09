package com.softserve.academy.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//import com.softserve.academy.test.DAO.CompetitionHBN;
//import com.softserve.academy.test.DAO.HibernateUtil;
import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;
import com.softserve.academy.test.DAO.CompetitionDAO;

@Service("CompetitionService")
public class CompetitionServiceImpl implements CompetitionService {
	private CompetitionServiceImpl() {
	}

	private static CompetitionServiceImpl Instance;

	public static CompetitionServiceImpl getInstance() {
		if (Instance == null) {
			Instance = new CompetitionServiceImpl();
		}
		return Instance;
	}

	@Autowired
	private CompetitionDAO CompetitionDAO;

	// private static CompetitionHBN chbn =
	// CompetitionHBN.getInstance(HibernateUtil.getSessionFactory());
	@Transactional
	@Override
	public List<Competition> retrieveAllCompetitions() {
		return CompetitionDAO.retrieveAllCompetitions();
	}

	@Transactional
	@Override
	public void createCompetition(Competition competition) {
		CompetitionDAO.createCompetition(competition);
	}

	@Transactional
	@Override
	public void updateCompetition(Competition competition) {
		CompetitionDAO.updateCompetition(competition);
	}

	@Transactional
	@Override
	public Competition retrieveCompetition(int id) {
		return CompetitionDAO.retrieveCompetition(id);
	}

	@Transactional
	@Override
	public void deleteCompetition(int id) {
		CompetitionDAO.deleteCompetition(id);
	}

	@Transactional
	@Override
	public void deleteProblemFromCompetition(Problem problem,
			Competition competition) {
		competition.removeProblem(problem);
	}
}
