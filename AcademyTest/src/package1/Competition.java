package package1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

public class Competition {
	public Competition() {
		super();
	}

	public Competition(ArrayList<Problem> problems,
			Calendar startTime, Calendar endTime) {
		this.problems = problems;
		this.startDate = startTime;
		this.startDate = endTime;
	}

	public Competition(Calendar startTime, Calendar endTime) {
		this.problems = new ArrayList<Problem>();
		this.startDate = startTime;
		this.startDate = endTime;
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
	 *            problem removed from competition
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

	public Calendar getStartTime() {
		return startDate;
	}

	public void setStartTime(Calendar start) {
		this.startDate = start;
	}

	public Calendar getEndTime() {
		return endDate;
	}

	public void setEndTime(Calendar end) {
		this.endDate = end;
	}

	private ArrayList<Problem> problems;
	private Calendar startDate;
	private Calendar endDate;
}