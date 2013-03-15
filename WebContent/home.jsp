<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*, sql.*"%>
<% User user = (User)session.getAttribute("user"); %>
<% DB db = (DB)application.getAttribute("db"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Quiz Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">


<!-- Styling -->
<link rel="stylesheet" type="text/css" href="home_layout.css" />
<link rel="stylesheet" type="text/css" href="jquery-ui-1.10.1.custom/css/smoothness/jquery-ui-1.10.1.custom.css" />
 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="jquery-ui-1.10.1.custom/js/jquery-ui-1.10.1.custom.min.js"></script>
 <script>
	$(function(){
		$("#other-info").tabs();
	});
</script>

</head>

<body>
<%@ include file="header_partial.jsp" %>
		<div id="user-info">
			<!-- Name and Logout option -->
			<h1><%= user.getProfileLink() %></h1>
			<form  action="LogoutServlet" method="post">
			<input type="submit" value="Logout" />
			</form><br>
			
			<!% user.setProfPicture("http://stanfordflipside.com/images/139not.png"); %>
			<img src='<%= user.getProfPicture() %> ' height="150" />
			<form  action="ProfPictureServlet" method="post">
			<input type="text" name="pictureURL" value="Image URL" />
			<input type="submit" value="Change profile picture" name="Change Profile Image" />
			</form>
			</br>
			
			
			<%
			History history = (History)request.getAttribute("history");
			out.println(history.toString());
			%>
			<br/>
			<b>Recent quiz making activity </b><br/>
			<%
			ArrayList<Quiz> recentlyCreated = (ArrayList<Quiz>)request.getAttribute("recentlyCreated");
			for(Quiz q : recentlyCreated){
				out.println(q.toLink() + "<br/>");
			}
			%>
			<br/>
			<div id ="achievements">
				<h2>Your Achievements</h2>
				<%
				ArrayList<Achievement> achievements = (ArrayList<Achievement>)request.getAttribute("achievements");
				for(Achievement a : achievements){
					out.println("<img src='" +a.getURL() + "' style='height: 20px'/>");
					out.println("<b>");
					out.println(a.getName());
					out.println(": ");
					out.println("</b>");
					out.println(a.getDescription());
					out.println("<br/>");
				}
				%>
			</div>
		</div><!-- User info -->
		<div id="other-info-wrapper">
			<div id="other-info">
				 <ul>
		    		<li><a href="#messages">Messages</a></li>		    		
		    		<li><a href="#friends">Friends</a></li>		    		
		    		<li><a href="#quizzes">Quizzes</a></li>
		    		<li><a href="#announcements">Announcements</a></li>
		    		<% 
		    		// only show admin panel to admins
		    		if(user.isAdmin()){
		    			out.println("<li><a href='#administration'>Administration</a></li>");
		    		}
		    		%>
		 		 </ul>
				<div id="messages">
					<h2>Your Messages:</h2>
					<b>Notes:</b><br/>
					<%
					ArrayList<Message> messages = (ArrayList<Message>)request.getAttribute("notes");
					out.println("You have "+messages.size()+" messages!");
					out.println("<br/>");
					for(Message m : messages){
						out.println(m.toHTML());
						System.out.println(">>>>>>>>>>>> "+ m.getBody());
					}
					%>
					
					<b>Challenges:</b><br/>
					<%
					ArrayList<Challenge> challenges = (ArrayList<Challenge>)request.getAttribute("challenges");
					for(Challenge c : challenges){
						out.println(c.getSrc() + " got " + c.getScore() + "% on " + c.toLink());
						out.println(">>> "+ c.getBody());
						out.println("<br/>");
					}
					%>
					<b>Friend Requests</b><br/>
					<%
					ArrayList<FriendRequest> friendRequests = (ArrayList<FriendRequest>)request.getAttribute("friendRequests");
					for(FriendRequest f : friendRequests){
						out.println(f.toHTML());
						if(user.hasFriendRequestFrom(f.getSrc()) && !user.isFriendsWith(f.getSrc())){
							out.println("<form action='AcceptFriendServlet' method='post'>" 
									+ "<input type='submit' value='Accept' />"
									+ "<input type='hidden' name='target' value='" + f.getSrc()
									+ "'>" + "</form>");
						} else if(user.isFriendsWith(f.getSrc())){
							out.println("<span style='color:blue;font-style:italic'>Request Accepted</span>");
						}
					}
					%>
				</div><!-- messages -->
				<div id="announcements">
					<h2>Announcements</h2>
					<%
					ArrayList<Announcement> announcements = (ArrayList<Announcement>)request.getAttribute("announcements");
					for(Announcement a : announcements){
						// provide admin option to delete announcement
						out.println("<p><span style='color:red;'>" + a.getDate() + ": </span>" + a.getMessage() + "</p>");
					}
					%>
				</div><!-- announcements -->
				<div id="friends">
					<h2>Friends</h2>
					
					<form action="UserSearchServlet" method="post">
					Find Friends: <input type="text" name="search_term">
					<input type="submit" value="Go!" /><br>
					</form></br>
					
					<%
					// list all friends and their history
					ArrayList<String> friends = user.getFriends();
					for(String f : friends){
						// print friend name w/ link to profile
						out.println("<h4 style='color:blue;'>" + user.getUserProfileLink(f) + "</h4></br>");
						
						// print recent quizzes taken
						out.println(f + " has recently taken these quizzes:</br>");
						ArrayList<Result> results = db.getRecentResults(f, 3);
						for(Result r : results){
							out.println(r.getPercentCorrect() + "% on " + Quiz.getQuizLink(r.getQuiz()) + "</br>");
						}
						
						// print recent quizzes made
						out.println(f + " has recently made these quizzes:</br>");
						ArrayList<Quiz> quizzes = db.getRecentQuizzes(f, 3);
						for(Quiz q : quizzes){
							out.println(q.toLink() + "</br>");
						}
						// print achievements
						out.println(f + " has earned the following achievements:</br>");
						ArrayList<Achievement> achievement = db.getAchievements(f);
						for(Achievement a : achievement){
							out.println(a.toString() + "<br>");
						}
					}
					%>
					
					
				</div><!-- friends -->
				
				<%if(user.isAdmin()){  %>
				<div id="administration">
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
				</div><!-- administration -->
				<% } %>
				
				<div id="quizzes">
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
							out.println(q.toLink() + "<br/>");
						}
					%>
					<br/>
						<!-- View all Quizzes -->
					<form  action="ListQuizzesServlet" method="post">
					<input type="submit" value="View All Quizzes" />
					</form><br>
					
			
			<!-- Search Quizzes -->
			<form action="QuizSearchServlet" method="post">
			Search Quiz Database: <input type="text" name="search_term">
			<input type="submit" value="Go!" /><br>
			</form>
			</br>
			
			<!-- Create a Quiz -->
			<form  action="quiz_create_init.jsp" method="post">
			<input type="submit" value="Create A Quiz!" />
			<% session.setAttribute("multi", false); %>
			<% session.setAttribute("noQuestions", false); %>
			<% session.setAttribute("fixRadioInput", false); %>	
			</form><br>
				</div>
			</div>
		</div>
<%@include file="content_end_partial.jsp" %>

</body>
</html>