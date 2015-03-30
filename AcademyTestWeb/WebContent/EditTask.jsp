<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softserve.academy.test.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="UpdateTask">
		<%
			Problem problem = (Problem) request.getAttribute("response");
		%>
		<input type="hidden" name="taskId" value="<%=problem.getId()%>">
		<p>
			Difficulty:<br> <select name="difficulty">
				<option value="Easy">Easy</option>
				<option value="Medium">Medium</option>
				<option value="Hard">Hard</option>
			</select>
		</p>
		<p>
			Name: <br> <input type="text" name="name"
				value="<%=problem.getName()%>" />
		</p>
		<p>
			Description: <br> <input type="text" name="description"
				value="<%=problem.getDescription()%>" />
		</p>
		<input type="submit" name="action" value="Update" /><br> 
		<input	type="submit" name="action" value="Delete from competition" /><br>
		<input type="submit" name="action" value="Delete from database" />
	</form>
</body>
</html>