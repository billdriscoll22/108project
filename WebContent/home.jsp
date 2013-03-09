<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*"%>
<% User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">

<!-- Styling -->
<style type="text/css">
#friend_panel {
	float: right;
}

</style>

</head>

<body>
<h1>Welcome <%= user.getID() %></h1>

<form style='text-align:center;' action="quiz_create_init.jsp" method="post">
<input type="submit" value="Create A Quiz" />
</form>

<b>Here's a list of popular quizzes:</b><br/>
<%
	ArrayList<Quiz> popularQuizzes = (ArrayList<Quiz>)request.getAttribute("popularQuizzes");
	for(Quiz q : popularQuizzes){
		out.println(q.getQuizId() + "<br/>");
	}
%>
<b>Here's a list of recent quizzes:</b> <br/>
<%
	ArrayList<Quiz> recentQuizzes = (ArrayList<Quiz>)request.getAttribute("recentQuizzes");
	for(Quiz q : recentQuizzes){
		out.println(q.getQuizId() + "<br/>");
	}
%>
<%
History history = (History)request.getAttribute("history");
out.println(history.toString());
%>
<b>Quizzes you've recently created: </b><br/>
<%
ArrayList<Quiz> recentlyCreated = (ArrayList<Quiz>)request.getAttribute("recentlyCreated");
for(Quiz q : recentlyCreated){
	out.println(q.getQuizId() + "<br/>");
}
%>
<b>Your achievements</b><br/>
<%
ArrayList<Achievement> achievements = (ArrayList<Achievement>)request.getAttribute("achievements");
for(Achievement a : achievements){
	out.println(a.getName());
}
%>

<h2>Your Messages:</h2>
<b>Notes:</b><br/>
<%
ArrayList<Message> messages = (ArrayList<Message>)request.getAttribute("notes");
System.out.println("THERE ARE "+messages.size()+" MESSAGES");
for(Message m : messages){
	out.println(m.toHTML());
	System.out.println(">>>>>>>>>>>> "+m.getBody());
}
%>
<b>Friend Requests</b><br/>
<%
ArrayList<FriendRequest> friendRequests = (ArrayList<FriendRequest>)request.getAttribute("friendRequests");
for(FriendRequest f : friendRequests){
	out.println(f.toHTML());
}
%>

<h2>Announcements</h2>
<%
ArrayList<Announcement> announcements = (ArrayList<Announcement>)request.getAttribute("announcements");
for(Announcement a : announcements){
	out.println(a.getMessage());
}
%>

<div id="friend_panel">
<h2>Friends</h2>

<form action="UserSearchServlet" method="post">
Find Friends: <input type="text" name="name">
<input type="submit" value="Go!" /><br>
</form>

<h3>Recent Activity</h3>
</div>



</body>
</html>