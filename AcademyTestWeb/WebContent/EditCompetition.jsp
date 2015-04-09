<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softserve.academy.test.model.entity.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<%
		Competition competition = (Competition) request
				.getAttribute("response");

		DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
	%>
	<br>Competition ID:
	<%=competition.getId()%>
	<br>Start Date:
	<%=df.format(competition.getStartTime())%>
	<br>End Date:
	<%=df.format(competition.getEndTime())%>
	<form action="EditProblem" method="POST">
	<table>
		
			<%
				for (Problem problem : competition.getAllProblems()) {
			%>
		
		<tr>
			<td><%=problem.getId() %></td>
			<td><input type="radio" name="taskid" value="<%=problem.getId()%>"></td>
			<td><%=problem.getDifficultyName()%></td>
			<td><%=problem.getName()%></td>
		</tr>
		<%
			}
		%>
		
		
		
	</table>
	<input type="submit" name="Edit" value="Edit task">
	<input type="submit" name="Edit" value="Edit task">
	<input type="submit" name="Edit" value="Edit task">
	<input type="submit" name="Edit" value="Save">
	<input type="submit" name="Edit" value="Delete">
	</form>
</body>
</html>