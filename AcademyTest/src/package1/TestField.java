package package1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestField {

	public static void main(String[] args) {
		//Competition comp = createCompetition();
		//System.out.println(comp);
		CompetitionSQL csql = new CompetitionSQL();
		csql.connectionTest();

	}

	public static Competition createCompetition() {
		Problem p1 = new Problem("EASY", "Problem 1", "Problem 1 description");
		Problem p2 = new Problem("hard", "Problem 2", "Problem 2 description");
		Problem p3 = new Problem("medium", "Problem 3", "Problem 3 description");
		ArrayList<Problem> problems = new ArrayList<Problem>();
		problems.add(p1);
		problems.add(p2);
		problems.add(p3);
		try {
			DateFormat df = new SimpleDateFormat("HH mm DD MM yyyy");
			Date startDate = df.parse("11 15 12 11 2014");
			Date endDate = df.parse("12 30 11 12 2015");
			Competition c = new Competition(problems, startDate, endDate);
			return c;
		} catch (ParseException e) {
			e.printStackTrace();
			return new Competition();
		}
	}

}
