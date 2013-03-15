<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>


    <% ArrayList<String> matches = (ArrayList<String>)request.getAttribute("results"); %>
    <% String search_term = (String)request.getAttribute("search_term"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Search Results</title>

</head>
<body>

<h1 style="text-align: center;">Quiz Results for "<%= search_term %>"</h1>


<%
// if there is no match
if(matches.isEmpty())
out.println("Sorry. No matches for that quiz name");
else {
	for(String quizId : matches){
		out.println(Quiz.getQuizLink(quizId) + "</br>");
	}
}

%>

<br>
<form style='text-align:center;' action="UserSearchServlet" method="post">
Search again: <input type="text" name="search_term" value="<%= search_term %>">
<input type="submit" value="Go!" />
</form>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>