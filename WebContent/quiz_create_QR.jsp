<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Question-Response</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<h1> Add Question-Response </h1>

<form action="QuizCreateServlet" method="post">
Enter question text: 
<br>
<textarea name="questionText"></textarea><br><br>
Possible correct answers (separated by ":"): <br><input type="text" name="questionAnswer"><br>
<input type="submit" name="init" value="Add Question-Response"><br><br>
<input type="submit" name="init" value="Cancel Question">
</form>


<%@include file="content_end_partial.jsp" %>

</body>
</html>