package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CompetitionDB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/AcademyTest";
	static final String USER = "root";
	static final String PASS = "root";
	static final String COMPETITION_SQL = "competitions";
	static final String PROBLEMS_SQL = "problems";
	static final String COMPETITION_ARRAY_SQL = "CompetitionUtil";

	private DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

	public void writeToDB(Competition competition) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);
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
			System.out.println("It works!");
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public void readFromDB(int CompetitionID) {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stat = conn.createStatement();
			String getCompetition = "SELECT c.competitionID, c.startdate, c.enddate, cu.problemId, p.problemName, p.problemDescription, p.difficulty from competitions c left join CompetitionUtil cu on c.competitionID = cu.competitionID	left join problems p on p.problemId=cu.problemId where c.CompetitionID ="
					+ CompetitionID;
			
			ResultSet queryResult = stat.executeQuery(getCompetition);

			queryResult.close();
			stat.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
}