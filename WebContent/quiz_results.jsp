<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% Quiz quiz = (Quiz)request.getAttribute("quiz"); %>
    <% ArrayList<Result> results = (ArrayList<Result>)request.getAttribute("results"); %>
    <% User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your results for <%= quiz.getQuizId() %></title>
</head>
<body>
<h1 style='text-align:center;'>Your Results For <%= quiz.toLink() %></h1>

<p>You have taken this quiz <%= results.size() %> times </p>
<p>High Score: <%= user.getBestScore(quiz.getQuizId()) %>% </p>
<p>Low Score: <%= user.getWorstScore(quiz.getQuizId()) %>% </p>
<p>Average Score: <%= user.getAverageScore(quiz.getQuizId()) %>% </p>

<h2>Complete Score History</h2>

<%
// list each result for this quiz
for(Result result : results){
	out.println("<p>Date Taken: " + result.getDateTaken() + "</p>");
	out.println("<p>Elapsed Time: " + result.getTimeUsed() / 60 + "Min " + result.getTimeUsed() % 60 + " Sec</p>");
	out.println("<p>Total Number Of Questions: " + result.getNumQuestions() + "</p>");
	out.println("<p>Number Of Questions You Answered Correctly: " + result.getNumCorrect() + "</p>");
	out.println("<p>Percent Right: " + result.getPercentCorrect() + "</p>");
}
%>


</br>		
<form style='text-align:center;' action='CreateChallengeServlet' method='post'>
<input type='submit' value='Challenge A Friend To This Quiz!' />
<input type='hidden' name='quiz' value='<%= quiz.getQuizId() %>'>
</form>
</br>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>