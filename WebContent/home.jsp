<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*, sql.*"%>
<% User user = (User)session.getAttribute("user"); %>
<% DB db = (DB)application.getAttribute("db"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">


<!-- Styling -->
<link rel="stylesheet" type="text/css" href="home_layout.css" />

</head>

<body>

<div id="header_panel">
	<h1 style="text-align:center;">Welcome to Quizzombie</h1>
</div>



<div id="user_panel">
<H2>User Panel</H2>

<!-- Name and Logout option -->
<form  action="LogoutServlet" method="post">
<%= user.getID() %>
<img src = "http://stanfordflipside.com/images/139not.png">
<input type="submit" value="Logout" />
</form><br>

<!-- Create a Quiz -->
<form  action="quiz_create_init.jsp" method="post">
<input type="submit" value="Create A Quiz!" />
</form><br>

<!-- View all Quizzes -->
<form  action="ListQuizzesServlet" method="post">
<input type="submit" value="View All Quizzes" />
</form><br>


<b>Popular Quizzes:</b><br/>
<%
	ArrayList<Quiz> popularQuizzes = (ArrayList<Quiz>)request.getAttribute("popularQuizzes");
	for(Quiz q : popularQuizzes){
		out.println(q.toLink() + "<br/>");
	}
%>
<b>New Quizzes:</b> <br/>
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
<b>Your New Quizzes: </b><br/>
<%
ArrayList<Quiz> recentlyCreated = (ArrayList<Quiz>)request.getAttribute("recentlyCreated");
for(Quiz q : recentlyCreated){
	out.println(q.getQuizId() + "<br/>");
}
%>
<b>Your Achievements</b><br/>
<%
ArrayList<Achievement> achievements = (ArrayList<Achievement>)request.getAttribute("achievements");
for(Achievement a : achievements){
	out.println(a.getName());
}
%>

</div>




<div id="message_panel">
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
</div>

<div id="announcement_panel">
	<h2>Announcements</h2>
	<%
	ArrayList<Announcement> announcements = (ArrayList<Announcement>)request.getAttribute("announcements");
	for(Announcement a : announcements){
		// provide admin option to delete announcement
		
		out.println("<p><span style='color:red;'>" + a.getDate() + ": </span>" + a.getMessage() + "</p>");
	}
	%>
</div>


<div id="friend_panel">
<h2>Friends</h2>

<form action="UserSearchServlet" method="post">
Find Friends: <input type="text" name="name">
<input type="submit" value="Go!" /><br>
</form>

<h3>Recent Activity</h3>
</div>

<div id="administration_panel">
<h2>Administration</h2>

<!-- Result Message -->
<p style="font-style:italic; color:red;">
<%
String message = (String)request.getAttribute("admin_message");
if(message != null) out.println(message);
%>
</p>

<!-- Post announcement -->
<form action="PostAnnouncementServlet" method="post">
<TEXTAREA rows="6" cols="20" name="txt"></TEXTAREA><br>
<input type="submit" value="Post Announcement" /><br>
</form>

<!-- Site Statistics -->
<H3>Site Statistics</H3>
<p> Number of quizzes created: <%= db.numQuizzes() %> </p>
<p> Number of users: <%= db.numUsers() %> </p> 

</div>



</body>
</html>