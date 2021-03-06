<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create a Quiz</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>

<h1> Create a New Quiz </h1>

<% if((Boolean)session.getAttribute("multi")) out.println("<h2 style='color:red;'> Remember, only multi-page quizzes can be graded immediately! </h2>"); %>
<% if((Boolean)session.getAttribute("fixRadioInput")) out.println("<h2 style='color:red;'> Please fill in all the quiz information! </h2>"); %>
<%
	session.setAttribute("multi", false);
	session.setAttribute("fixRadioInput", false);
%>

<form action="QuizCreateServlet" method="post">
Name of quiz: <input type="text" name="quizId"><br><br>

Are the questions in random order?<br>
<input type="radio" name="order" value="random">Random<br>
<input type="radio" name="order" value="ordered">Ordered
<br><br>

One page or multiple pages?<br>
<input type="radio" name="pages" value="onePage">One Page<br>
<input type="radio" name="pages" value="multiPage">Multiple Pages
<br><br>

When is the quiz graded?<br>
<input type="radio" name="whenGraded" value="immediate">Immediately (multi-page only)<br>
<input type="radio" name="whenGraded" value="atEnd">At the End of the Quiz
<br><br>

Profile Image:<input type="text" name="imageURL" value="Image URL" /><br><br>
Quiz Description: <br><textarea name="description"></textarea><br><br>

<input type="submit" name="init"  value="Create Quiz" /><br><br>
<input type="submit" name="init"  value="Cancel" />
</form>
<%@include file="content_end_partial.jsp" %>

</body>
</html>