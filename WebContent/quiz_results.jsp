<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% Quiz quiz = (Quiz)request.getAttribute("quiz"); %>
    <% Result result = (Result)request.getAttribute("result"); %>
    <% User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your results for <%= quiz.toLink() %></title>
</head>
<body>
<h1 style='text-align:center;'>Your results for <%= quiz.toLink() %></h1>

<p>Date Taken: <%= result.getDateTaken() %> </p>
<p>Elapsed Time: <%= result.getTimeUsed() %></p>
<p>Total Number Of Questions: <%= result.getNumQuestions() %></p>
<p>Number Of Questions You Answered Correctly: <%= result.getNumCorrect() %></p>
<p>Percent Right: <%= result.getPercentCorrect() %>% </p>

</br>		
<form style='text-align:center;' action='CreateChallengeServlet' method='post'>
<input type='submit' value='Challenge A Friend To This Quiz!' />
<input type='hidden' name='quiz' value='<%= quiz.getQuizId() %>'>
</form>
</br>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>