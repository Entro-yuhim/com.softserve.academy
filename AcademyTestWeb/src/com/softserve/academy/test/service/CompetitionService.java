package com.softserve.academy.test.service;

import java.util.List;

import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;

public interface CompetitionService {
	public List<Competition> retrieveAllCompetitions();
	public void createCompetition(Competition competition);
	public void updateCompetition(Competition competition);
	public Competition retrieveCompetition(int id);
	public void deleteCompetition(int id);
	public void deleteProblemFromCompetition(Problem problem, Competition competition);
}