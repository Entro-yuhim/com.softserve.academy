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

	public Competition(ArrayList<Problem> problems, Calendar startTime,
			Calendar endTime) {
		this.problems = problems;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Competition(Calendar startTime, Calendar endTime) {
		this.problems = new ArrayList<Problem>();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
		String start = df.format(startTime.getTime());
		String end = df.format(endTime.getTime());
		return ( start+ " " + end+ " " + problems.toString());
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
		return startTime;
	}

	public void setStartTime(Calendar start) {
		this.startTime = start;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar end) {
		this.endTime = end;
	}

	private ArrayList<Problem> problems;
	private Calendar startTime;
	private Calendar endTime;
}