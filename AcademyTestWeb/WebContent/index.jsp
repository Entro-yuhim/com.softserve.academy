<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softserve.academy.test.model.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Competition (academy project)</title>
</head>
<body>
	<form method="POST" action="ProcessQuery">
		<input type="submit" name="action" value="Get competitions" /> <br>
		<input type="submit" name="action" value="Edit competition" /><br>
		<input type="submit" name="action" value="Delete"/>
		<%
			Object resp = request.getAttribute("response");
			DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
			if (resp instanceof ArrayList) {
				ArrayList<Competition> competitions = (ArrayList<Competition>) resp;
				if (!(competitions == null)) {
					out.println("<table>");
					for (Competition competition : competitions) {
						out.println("<tr>");
						out.println("<td><input type=\"radio\" name=\"id\" value=\""
								+ competition.getId() + "\"></td>");
						out.println("<td><br>Competition ID"
								+ competition.getId() + "</td>");
						out.println("<td><br>Start Date:"
								+ df.format(competition.getStartTime())
								+ "</td>");
						out.println("<td><br>End Date"
								+ df.format(competition.getEndTime()) + "</td>");
						out.println("</tr>");
					}
					out.println("</table>");
				}
			}
			if (resp instanceof Competition) {
				Competition competition = (Competition) resp;
				out.println();
				out.println("<br>Competition ID" + competition.getId());
				out.println("<br>Start Date:"
						+ df.format(competition.getStartTime()));
				out.println("<br>End Date"
						+ df.format(competition.getEndTime()));
				out.println("<table>");
				for (Problem problem : competition.getAllProblems()) {
					out.println("<tr>");
					out.println("<td><input type=\"radio\" name=\"id\" value=\""
							+ problem.getId() + "\"></td>");
					out.println("<td>Difficulty " + problem.getDifficultyName()
							+ "</td>");
					out.println("<td>Name " + problem.getName() + "</td>");
					out.println("<td>Description" + problem.getDescription()
							+ "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
			}
		%>
	</form>
</body>
</html>