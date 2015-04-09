package com.softserve.academy.test.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "problems")
public class Problem {
	
	@Id
	@GeneratedValue
	@Column(name = "problemId", unique = true, nullable = false)
	private int id;
	@ManyToMany(
			fetch = FetchType.EAGER,
			mappedBy="problems",
			targetEntity=Competition.class
			)
	private List<Competition> competitions = new ArrayList<Competition>();
	
	
	@Column(name = "difficulty", nullable = false)
	private Difficulty difficulty;

	private enum Difficulty {
		EASY, MEDIUM, HARD
	}

	@Column(name = "problemName", nullable = false)
	private String name;
	
	@Column(name = "problemDescription", nullable = false)
	private String description;

	public Problem() {
	}

	public boolean equals(Problem p) {
		if (this.id == p.getId()) {
			return true;
		} else
			return false;
	}

	// Debug toString implementation
	@Override
	public String toString() {
		return id + " " + this.getDifficultyName() + " " + name + " "
				+ description;
	}

	public Problem(String difficultyName, String name, String description) {
		this.difficulty = resolveDifficulty(difficultyName);
		this.name = name;
		this.description = description;
	}

	public Problem(int id, String difficultyName, String name,
			String description) {
		this.id = id;
		this.difficulty = resolveDifficulty(difficultyName);
		this.name = name;
		this.description = description;
	}

	/**
	 * Sets ID of the problem Id is even more unique!
	 * 
	 * @param id
	 *            of the problem(gotten somewhere. Anywhere)
	 */
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Difficulty getDiffuclty() {
		return this.difficulty;
	}

	public String getDifficultyName() {
		switch (this.difficulty) {
		case EASY:
			return "Easy";
		case MEDIUM:
			return "Medium";
		default:
			return "Hard";
		}
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public void setDifficultyByName(String difficulty) {
		this.difficulty = resolveDifficulty(difficulty);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Difficulty resolveDifficulty(String difficultyName) {

		if (difficultyName.toUpperCase().equals("EASY")) {
			return Difficulty.EASY;
		} else if (difficultyName.toUpperCase().equals("MEDIUM")) {
			return Difficulty.MEDIUM;
		} else {
			return Difficulty.HARD;
		}

	}

}
