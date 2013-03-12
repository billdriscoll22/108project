<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*, sql.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Take Quiz</title>
</head>
<body>
<h1> Poop </h1>

<%
DB db = (DB)application.getAttribute("db"); 
Quiz q = db.getQuiz("do you know synergy?");
ArrayList<Question> questions = q.getQuestions();



%>

</body>
</html>