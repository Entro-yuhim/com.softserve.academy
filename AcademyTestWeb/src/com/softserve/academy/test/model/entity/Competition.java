package com.softserve.academy.test.model.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "competitions")
public class Competition{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CompetitionId", unique = true, nullable = false)
	private int id;
	@Column(name = "startDate")
	private Date startDate;
	@Column(name = "endDate")
	private Date endDate;
	
	 
	@ManyToMany(
			targetEntity=com.softserve.academy.test.model.entity.Problem.class,
			fetch = FetchType.EAGER, cascade = CascadeType.ALL
	)
	@JoinTable(
			name = "CompetitionUtil", 
			joinColumns = { @JoinColumn(name = "CompetitionId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "problemId", nullable = false, updatable = false) }
		)
	private List<Problem> problems;

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

	public Competition(int id, Date startDate, Date endDate) {
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
//	@Override
//	public String toString() {
//		DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
//		String start = df.format(startDate);
//		String end = df.format(endDate);
//		return (start + " " + end + " " + problems.toString());
//	}

	public void addProblem(Problem prob) {
		this.problems.add(prob);
	}

	public boolean removeProblem(Problem prob) {
		boolean b = false;
		Iterator<Problem> it = this.problems.iterator();
		while(it.hasNext()){
			if (it.next().equals(prob)){
				it.remove();
				b = true;
			}
		}
		return b;
	}
	public boolean removeProblem(int id) {
		boolean b = false;
		Iterator<Problem> it = this.problems.iterator();
		while(it.hasNext()){
			if (it.next().getId() == id){
				it.remove();
				b = true;
			}
		}
		return b;
	}

	public List<Problem> getAllProblems() {
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