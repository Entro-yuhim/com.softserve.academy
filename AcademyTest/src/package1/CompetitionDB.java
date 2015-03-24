package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CompetitionDB {
	private static CompetitionDB Instance;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/AcademyTest";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static final String COMPETITION_SQL = "competitions";
	private static final String PROBLEMS_SQL = "problems";
	private static final String COMPETITION_ARRAY_SQL = "CompetitionUtil";
	private Connection conn = null;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

	private CompetitionDB() {
	};

	public static CompetitionDB getInstance() {
		if (Instance == null) {
			try {
				Class.forName(JDBC_DRIVER);
				Instance = new CompetitionDB();

			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
		}
		return Instance;
	}

	public void writeToDB(Competition competition) {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stat = conn.createStatement();
			String statement = "INSERT INTO " + COMPETITION_SQL
					+ "(startdate, enddate)" + " VALUES ('"
					+ df.format(competition.getStartTime()) + "', '"
					+ df.format(competition.getEndTime()) + "')";
			stat.executeUpdate(statement);
			stat.close();

			String problemStatement = "INSERT INTO " + PROBLEMS_SQL
					+ " VALUES (?, ?, ?, ?)";
			String joinStat = "INSERT INTO " + COMPETITION_ARRAY_SQL
					+ " VALUES (" + competition.getId() + ", ?)";
			PreparedStatement addProblems = conn
					.prepareStatement(problemStatement);

			PreparedStatement addConnection = conn.prepareStatement(joinStat);
			for (Problem problem : competition.getAllProblems()) {
				addConnection.setInt(1, problem.getId());
				addProblems.setInt(1, problem.getId());
				addProblems.setString(2, problem.getDifficultyName());
				addProblems.setString(3, problem.getName());
				addProblems.setString(4, problem.getDescription());
				addProblems.executeUpdate();
				addConnection.executeUpdate();
			}
			addConnection.close();
			addProblems.close();

			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void insertProblem(Problem problem) {
	}

	public Competition readFromDB(int CompetitionID) {

		Competition competition = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stat = conn.createStatement();
			String competitionQuery = "Select c.competitionid, c.startDate, c.endDate FROM "
					+ COMPETITION_SQL
					+ " c WHERE c.competitionId = "
					+ CompetitionID;
			System.out.println(competitionQuery);
			ResultSet queryResult = stat.executeQuery(competitionQuery);

			if (queryResult.wasNull()) {
				// return null;
			} else {
				queryResult.next();
				int id = queryResult.getInt(1);
				Date startDate = queryResult.getTimestamp(2);
				Date endDate = queryResult.getTimestamp(3);
				ArrayList<Problem> problems = getProblemsForCompetition(conn,
						CompetitionID);
				competition = new Competition(id, problems, startDate, endDate);
			}

			queryResult.close();
			stat.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			return competition;
		}
	}

	public ArrayList<Problem> getProblemsForCompetition(Connection conn,
			int CompetitionID) {
		ArrayList<Problem> problems = null;
		try {
			String problemsQuery = "select cu.problemid, p.problemname, p.problemdescription, p.difficulty from "
					+ PROBLEMS_SQL
					+ " p left join "
					+ COMPETITION_ARRAY_SQL
					+ " cu on cu.problemId=p.problemId where cu.competitionid="
					+ CompetitionID;
			Statement stat = conn.createStatement();
			ResultSet problemResultSet = stat.executeQuery(problemsQuery);

			if (!problemResultSet.wasNull()) {
				problems = new ArrayList<Problem>();
				while (problemResultSet.next()) {
					int problemId = problemResultSet.getInt(1);
					String difficulty = problemResultSet.getString(4);
					String name = problemResultSet.getString(2);
					String description = problemResultSet.getString(3);
					Problem problem = new Problem(problemId, difficulty, name,
							description);
					problems.add(problem);
				}
				problemResultSet.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			return problems;
		}
	}
}