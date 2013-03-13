<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% Quiz quiz = (Quiz)request.getAttribute("quiz"); %>
    <% Result result = (Result)request.getAttribute("result"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your results for <%= quiz.getQuizId() %></title>
</head>
<body>

<p>Elapsed Time: = <%= result.getTimeUsed() %></p>
<p>Total Number Of Questions: = <%= result.getNumQuestions() %></p>
<p>Number Of Questions You Answered Correctly: = <%= result.getNumCorrect() %></p>
<p>Percent Right: = <%= result.getPercentCorrect() %>% </p>


<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>