<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*, sql.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<% User user = (User)session.getAttribute("user"); %>
<% DB db = (DB)application.getAttribute("db"); %>
<%
String quizId = (String) request.getParameter("id");
Quiz q = db.getQuiz(quizId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Take Quiz: quizId</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<h1> <%= quizId %> </h1>

<%@include file="content_end_partial.jsp" %>

</body>
</html>