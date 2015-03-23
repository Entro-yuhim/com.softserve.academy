package com.softserve.academy.test.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

//TODO: Change start&endTime to Date

public class Competition {

	private ArrayList<Problem> problems;
	private Date startDate;
	private Date endDate;
	private int id;

	public Competition() {
		super();
	}

	public Competition(ArrayList<Problem> problems, Date startDate, Date endDate) {
		this.problems = problems;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Competition(int id, ArrayList<Problem> problems, Date startDate,
			Date endDate) {
		this.id = id;
		this.problems = problems;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Competition(int id, Date startDate,
			Date endDate) {
		this.id = id;
		this.problems = new ArrayList<Problem>();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Competition(Date startDate, Date endDate) {
		this.problems = new ArrayList<Problem>();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Debug toString implementation
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
		String start = df.format(startDate);
		String end = df.format(endDate);
		return (start + " " + end + " " + problems.toString());
	}

	/**
	 * Add problem to the competition
	 * 
	 * @param problem
	 *            problem added to be competition
	 */
	public void addProblem(Problem prob) {
		this.problems.add(prob);
	}

	/**
	 * Remove problem from the competition
	 * 
	 * @param problem
	 *            problem removed from competition??
	 */
	public boolean removeProblem(Problem prob) {
		int i = 0;
		for (Problem p : this.problems) {
			i++;
			if (p == prob) {
				this.problems.remove(i);
			}
		}
		return true;
	}

	public ArrayList<Problem> getAllProblems() {
		return problems;
	}

	public void setAllProblems(ArrayList<Problem> prob) {
		this.problems = prob;
	}

	public Date getStartTime() {
		return startDate;
	}

	public void setStartTime(Date start) {
		this.startDate = start;
	}

	public Date getEndTime() {
		return endDate;
	}

	public void setEndTime(Date end) {
		this.endDate = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}