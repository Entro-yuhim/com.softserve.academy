<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softserve.academy.test.model.entity.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Competition list</title>
</head>
<body>
	<form action ="EditComp" method="POST">
		<%
			DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
			HashSet<Competition> resp = (HashSet<Competition>) request
					.getAttribute("response");
		%>
		<table border="2">
			<tr>
				<th></th>
				<th>Start Date</th>
				<th>End Date</th>
			</tr>
			<%
			Iterator<Competition> it = resp.iterator();
			while(it.hasNext()){
				Competition comp = it.next();
			%>

			<tr>
				<td><input type="radio" name="id" value="<%=comp.getId()%>"></td>
				<td><%=comp.getId()%></td>
				<td><%=df.format(comp.getStartTime())%></td>
				<td><%=df.format(comp.getEndTime())%></td>
			</tr>

			<%
				}
			%>
		</table>
		<input type = "submit" name ="action" value ="Edit"/>
		<input type="submit" name="action" value="Delete" />
	</form>
</body>
</html>