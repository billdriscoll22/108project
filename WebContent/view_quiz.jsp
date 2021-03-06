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
<%
	ArrayList<Result> topScores = (ArrayList<Result>) request.getAttribute("topScores");
	ArrayList<Result> top24 = (ArrayList<Result>) request.getAttribute("top24");
	ArrayList<Result> mostRecent = (ArrayList<Result>) request.getAttribute("mostRecent");
	Double averageRight = (Double) request.getAttribute("averageRight");
	Double averageTime = (Double) request.getAttribute("averageTime");
%>
<%
	ArrayList<Result> userResults = (ArrayList<Result>) request.getAttribute("userResults");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=quiz.getQuizId()%></title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<div id="quiz" style="width: 1000px; margin-left: auto; margin-right: auto;">
	<h1 style='text-align: center;'><%=quiz.getQuizId()%></h1>
	<img src='<%=quiz.getImageURL() %>' height='100' />

	<p>
		Created By:
		<a href='ProfileViewServlet?user=<%= quiz.getCreatorId()%>'><%=quiz.getCreatorId()%></a></p>
	<p>
		Date Created:
		<%=quiz.getDateCreated()%></p>
	<p>
		Number Of Questions:
		<%=quiz.getNumQuestions()%></p>
		
	<p>
		Description: <%=quiz.getDescription() %> </p>
		
		<h2 style='text-align: center;'>Your Performance On This Quiz</h2>
	<%
	
		if(userResults.isEmpty()){
			out.println("<p style='text-align:center; color:red;'>You haven't taken this quiz yet! </p>");
		}
	
		else {  // print history
			out.println("<p style='text-align:center;'>You have taken this quiz " + userResults.size() + " times </p>");
			out.println("<p style='text-align:center;'>High Score: " +  user.getBestScore(quiz.getQuizId()) + "  </p>");
			out.println("<p style='text-align:center;'>Low Score: " +  user.getWorstScore(quiz.getQuizId()) + "  </p>");
			out.println("<p style='text-align:center;'>Average Score: " +  user.getAverageScore(quiz.getQuizId()) + " </p>");
			out.println("<p style='text-align:center;font-weight:bold;'>See your complete history for " + userResults.get(0).getResultLink() + " </p>");
		}
	%>
	
	<h2 style='text-align: center'>Quiz Stats</h2>
	<p style="text-align: center">The average number of questions correct is: <%= averageRight %></p>
	<p style="text-align: center">The average time taken is: <%= averageTime %> seconds</p>
	
	<h2 style='text-align: center;'>Most recent results</h2>
	<%
		for(Result r : mostRecent){
		out.println("<p style='text-align: center;'>" + User.getUserProfileLink(r.getUserId()) + " scored " + r.getPercentCorrect() + "% in " + 
			r.getTimeUsed() + " seconds on " + r.getDateTaken() + "</p>");
		}
		%>
	<h2 style='text-align: center;'>Top Scores Past 24 Hours</h2>
	<%
	for(Result r : top24){
		out.println("<p style='text-align: center;'>" + User.getUserProfileLink(r.getUserId()) + " scored " + r.getPercentCorrect() + "% in " + 
			r.getTimeUsed() + " seconds on " + r.getDateTaken() + "</p>");
	}
	%>

	<h2 style='text-align: center;'>Top Scores All Time</h2>
	<%
		// print all top scores
	for(Result r : topScores){
			out.println("<p style='text-align: center;'>" + User.getUserProfileLink(r.getUserId()) + " scored " + r.getPercentCorrect() + "% in " + 
				r.getTimeUsed() + " seconds on " + r.getDateTaken() + "</p>");
		}
	%>

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
			out.println("<form style='text-align: center;' action='RemoveQuizServlet' method='post'>"
					+ "<input type='submit' value='Delete Quiz' />"
					+ "<input type='hidden' name='target' value='" + quiz.getQuizId()
					+ "'>" + "</form>");
		}
	
	// if admin, allow option to clear quiz history
			if (user.isAdmin()) {
				// button to delete user
				out.println("<form style='text-align: center;' action='ClearQuizHistoryServlet' method='post'>"
						+ "<input type='submit' value='Clear History' />"
						+ "<input type='hidden' name='target' value='" + quiz.getQuizId()
						+ "'>" + "</form>");
			}
	%>

	<form style='text-align: center;' action="HomeServlet" method="post">
		<input type="submit" value="Home" />
	</form>
	</div>
	<%@include file="content_end_partial.jsp" %>
</body>
</html>