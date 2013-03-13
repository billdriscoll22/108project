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

<p>Created By: <%= quiz.getCreatorId() %></p>
<p>Date Created: <%= quiz.getDateCreated() %></p>
<p>Number Of Questions: <%= quiz.getNumQuestions() %></p>

<br>
<form style='text-align:center;' action="TakeQuizServlet" method="post">
<input type="hidden" name="quizID" value="<%= quiz.getQuizId() %>">
<input type="submit" value="Take Quiz" />
</form>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>
</body>
</html>