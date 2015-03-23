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
		<input type="submit" value="Submit" />
	</form>
	<%
		ArrayList<Competition> competitions = (ArrayList<Competition>) request
				.getAttribute("response");
		DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		if (!(competitions == null)) {
			out.println("<table>");
			for (Competition competition : competitions) {
				out.println("<tr>");
				out.println("<td><input type=\"checkbox\"></td>");
				out.println("<td><br>Competition ID" + competition.getId()
						+ "</td>");
				out.println("<td><br>Start Date:"
						+ df.format(competition.getStartTime()) + "</td>");
				out.println("<td><br>End Date"
						+ df.format(competition.getEndTime()) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
	%>

</body>
</html>