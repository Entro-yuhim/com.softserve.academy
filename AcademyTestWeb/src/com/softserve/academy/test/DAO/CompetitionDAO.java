package com.softserve.academy.test.DAO;
import java.util.List;

import com.softserve.academy.test.model.entity.*;

public interface CompetitionDAO {
	public List<Competition> retrieveAllCompetitions();
	public void createCompetition(Competition competition);
	public void updateCompetition(Competition competition);
	public Competition retrieveCompetition(int id);
	public void deleteCompetition(int id);
}
