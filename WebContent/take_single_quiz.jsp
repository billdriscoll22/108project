<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% Quiz quiz = (Quiz)request.getAttribute("quiz"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= quiz.getQuizId() %></title>
</head>
<body>

<h1 style='text-align:center;'><%= quiz.getQuizId() %></h1>

<form action="CorrectQuizServlet" method="post">

<%
// write out all questions
while(true){
	Question q = quiz.nextQuestion();
	if(q == null) break;
	else {
		out.println(q.toHTML() + "<br>");
	}
}

%>

<input type="hidden" name="quizID" value="<%= quiz.getQuizId() %>">
<input type="submit" value="Submit Answers" />
</form>


<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Cancel" />
</form>
</body>
</html>