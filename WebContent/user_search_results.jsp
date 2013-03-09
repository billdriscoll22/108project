<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% DB db = (DB)application.getAttribute("db"); %>
    <% User user = (User)session.getAttribute("user"); %>
    <% User account = (User)request.getAttribute("account"); %>
    <% String name = (String)request.getAttribute("name"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>

</head>
<body>

<h1 style="text-align: center;">Search Results For <%= name %></h1>


<%
// if there is no match
if(account == null)
out.println("Sorry. No matches for that user name");
else {
	// show name and friendship status
	out.println("<h2>" + name + ": ");
	
	// check if they are already friends. offer option to remove friend
	if(user.getFriends().contains(name)){
		out.println("<form action='RemoveFriendServlet' method='post'>" + 
		"<input type='submit' value='Remove Friend' />" +
		"<input type='hidden' name='target' value='" + name +"'>" +
		"</form>");
	}
	
	// check if a friend request has been offered
	else if(user.hasRequestFrom(name)){
		out.println("<form action='AcceptFriendServlet' method='post'>" + 
				"<input type='submit' value='Accept Friend Request' />" +
				"<input type='hidden' name='target' value='" + name +"'>" +
				"</form>");
	}
	
	// check if a friend request has already been sent
	else if(account.hasRequestFrom(user.getID())){
		out.println("<p style='font-style:italic;'>You've already sent a friend request</p>");
	}
	
	// offer to send friend request
	else {
		out.println("<form action='RequestFriendServlet' method='post'>" + 
				"<input type='submit' value='Send Friend Request' />" +
				"<input type='hidden' name='target' value='" + name +"'>" +
				"</form>");
	}
	// end friendship status
	out.println("</h2>");
	
	// list quizes this user has created
	out.println("<h3>" + name + "'s quizzes</h2>");
	ArrayList<Quiz> quizzes = account.getQuizzes();
	for(Quiz q : quizzes){
		out.println(q.getQuizId() + "<br>");
	}
	
	// list achievements
	out.println("<h3>" + name + "'s achievements</h2>");
	ArrayList<Achievement> achievements = account.getAchievements();
	for(Achievement a : achievements){
		out.println(a.toString());
	}
	
	
	// list history
	out.println("<br><h3>" + name + "'s history</h2>");
	History h = account.getHistory();
	out.println(h.toString());
}

%>

<br>
<form style='text-align:center;' action="UserSearchServlet" method="post">
Search again: <input type="text" name="name" value="<%= name %>">
<input type="submit" value="Go!" />
</form>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>