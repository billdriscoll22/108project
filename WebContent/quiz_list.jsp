<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% DB db = (DB)request.getAttribute("db"); %>
    <meta http-equiv="Pragma" content="no-cache">
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Quizzes</title>
</head>
<body>
<h1 style='text-align:center;'>All Quizzes</h1>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

<%
// list each quiz
ArrayList<Quiz> quizzes = db.getQuizzes();
for(Quiz q : quizzes){
	out.println(q.toLink() + "</br>");
}
%>


<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>