package com.softserve.academy.test.service;

import java.util.List;

import com.softserve.academy.test.model.entity.Problem;

public interface ProblemService {
	public List<Problem> retrieveAllProblems();
	public void createProblem(Problem p);
	public void updateProblem(Problem p);
	public Problem retrieveProblem(int id);
	public void deleteProblem(int id);	
}
