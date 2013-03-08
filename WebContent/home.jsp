<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*"%>
<% User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">
</head>
<body>
<h1>Welcome, <%= user.getID() %></h1>
<b>Here's a list of popular quizzes:</b><br/>
<%
	ArrayList<Quiz> popularQuizzes = (ArrayList<Quiz>)request.getAttribute("popularQuizzes");
	for(Quiz q : popularQuizzes){
		out.println(q.getQuizId() + "<br/>");
	}
%>
<b>Here's a list of recent quizzes:</b> <br/>
<%
	ArrayList<Quiz> recentQuizzes = (ArrayList<Quiz>)request.getAttribute("recentQuizzes");
	for(Quiz q : recentQuizzes){
		out.println(q.getQuizId() + "<br/>");
	}
%>
<%
History history = (History)request.getAttribute("history");
out.println(history.toString());
%>
<b>Quizzes you've recently created: </b><br/>
<%
ArrayList<Quiz> recentlyCreated = (ArrayList<Quiz>)request.getAttribute("recentlyCreated");
for(Quiz q : recentlyCreated){
	out.println(q.getQuizId() + "<br/>");
}
%>
<b>Your achievements</b><br/>
<%
ArrayList<Achievement> achievements = (ArrayList<Achievement>)request.getAttribute("achievements");
for(Achievement a : achievements){
	out.println(a.getName());
}
%>
</body>
</html>