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
		return id + " " + this.getDifficulty() + " " + name + " " + description;
	}

	public Problem(String diff, String name, String description) {
		currentId++;
		this.id = currentId;
		diff = diff.toUpperCase();


		if (diff.contains("EASY")) {
			this.difficulty = Difficulty.EASY;
		}
		if (diff.contains("MEDIUM")) {

			this.difficulty = Difficulty.MEDIUM;
		}
		if (diff.contains("HARD")) {

			this.difficulty = Difficulty.HARD;
		}

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
		default:
			return "Hard";
		}
	}

	public void setDifficulty(String diff) {
		if (diff.toUpperCase() == "EASY") {
			this.difficulty = Difficulty.EASY;
		} else if (diff.toUpperCase() == "MEDIUM") {
			this.difficulty = Difficulty.MEDIUM;
		} else if (diff.toUpperCase() == "HARD") {
			this.difficulty = Difficulty.HARD;
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
