<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*, sql.*"%>
<meta http-equiv="Pragma" content="no-cache">
<%
	Quiz quiz = (Quiz) request.getAttribute("quiz");
%>
<%
	User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=quiz.getQuizId()%></title>
</head>
<body>

	<h1 style='text-align: center;'><%=quiz.getQuizId()%></h1>

	<p>
		Created By:
		<%=quiz.getCreatorId()%></p>
	<p>
		Date Created:
		<%=quiz.getDateCreated()%></p>
	<p>
		Number Of Questions:
		<%=quiz.getNumQuestions()%></p>

	<h2 style='text-align: center;'>Top Scores</h2>

	<br>
	<form style='text-align: center;' action='TakeQuizServlet'
		method='post'>
		<input type="hidden" name="quizID" value="<%=quiz.getQuizId()%>">
		<input type="submit" value="Take Quiz" />
	</form>

	<%
		// if admin, allow option to delete quiz
		if (user.isAdmin()) {
			// button to delete user
			out.println("<form action='RemoveQuizServlet' method='post'>"
					+ "<input type='submit' value='Delete Quiz' />"
					+ "<input type='hidden' name='target' value='" + quiz.getQuizId()
					+ "'>" + "</form>");
		}
	
	// if admin, allow option to clear quiz history
			if (user.isAdmin()) {
				// button to delete user
				out.println("<form action='ClearQuizHistoryServlet' method='post'>"
						+ "<input type='submit' value='Clear History' />"
						+ "<input type='hidden' name='target' value='" + quiz.getQuizId()
						+ "'>" + "</form>");
			}
	%>

	<form style='text-align: center;' action="HomeServlet" method="post">
		<input type="submit" value="Home" />
	</form>
</body>
</html>