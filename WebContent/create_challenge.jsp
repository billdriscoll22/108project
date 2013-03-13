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
<title>Send A Challenge</title>
</head>
<body>
<h1 style='text-align:center;'>Challenge A Friend To <%= quiz.toLink() %></h1>


<form style='text-align:center;' action="SendChallengeServlet" method="post">
Choose A Friend To Challenge: <select name="friend">
<%
	ArrayList<String> friends = user.getFriends();
	for(String f : friends){
		out.println("<option value='" + f + "'>" + f + "</option>");
	}
%>
</select></br></br>

Include a Message: </br>

<textarea rows='5' cols='30' name='txt'></textarea><br>
<input type="submit" value="Challenge!" />
<input type='hidden' name='target' value='<%=request.getParameter("target") %>'>
<input type='hidden' name='quiz' value='<%= quiz.getQuizId() %>'>
</form>

<br>
<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>

</body>
