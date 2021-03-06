<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% Quiz quiz = (Quiz)session.getAttribute("multiQuiz"); %>
    <% Question q = (Question)request.getAttribute("nextQuestion"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= quiz.getQuizId() %></title>
</head>
<body>

<%@ include file="header_partial.jsp" %>

<h1 style='text-align:center;'><%= quiz.getQuizId() %></h1>

<h3 style='text-align:center;color:red;'>
<%
// display feedback from last question if applicable
String feedback = (String)request.getAttribute("feedback");
if(feedback != null){
	out.println(feedback);
}
%>
</h3>
<form action="MultiQuizServlet" method="post">

<%	
	out.println(q.toHTML() + "<br>");
%>

<input type="hidden" name="questionNum" value="<%= q.getNumber() %>">
<input type="hidden" name="quizID" value="<%= quiz.getQuizId() %>">
<input type="submit" value="Submit" />
</form>


<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Cancel" />
</form>
<%@include file="content_end_partial.jsp" %>

</body>
</html>