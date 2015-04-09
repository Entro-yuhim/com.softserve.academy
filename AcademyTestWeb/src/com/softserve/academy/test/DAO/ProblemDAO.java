package com.softserve.academy.test.DAO;
import java.util.List;

import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;

public interface ProblemDAO {
	public List<Problem> retrieveAllProblems();
	public void createProblem(Problem problem);
	public void updateProblem(Problem problem);
	public Problem retrieveProblem(int id);
	public void deleteProblem(int id);
}
