package package1;

public class Problem {
	public Problem() {
	}

	public boolean equals(Problem p) {
		if (this.id == p.getId()) {
			return true;
		} else
			return false;
	}

	@Override
	public String toString() {
		return id + " " + difficulty + " " + name + " " + description;
	}

	public Problem(String difficulty, String name, String description) {
		currentId++;
		this.id = currentId;
		this.setDifficulty(difficulty);
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDifficulty() {
		switch (this.difficulty) {
		case EASY:
			return "Easy";
		case MEDIUM:
			return "Medium";
		case HARD:
			return "Hard";
		default:
			return "";
		}
	}

	public void setDifficulty(String difficulty) {
		switch (difficulty.toUpperCase()) {
		case "EASY":
			this.difficulty = Difficulty.EASY;
		case "MEDIUM":
			this.difficulty = Difficulty.MEDIUM;
		case "HARD":
			this.difficulty = Difficulty.HARD;
		default:

		}
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

	private int id;
	private static int currentId = 0;
	private Difficulty difficulty;

	private enum Difficulty {
		EASY, MEDIUM, HARD
	}

	private String name;
	private String description;
}
