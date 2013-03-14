<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*, sql.*"%>

<%
	User user = (User) session.getAttribute("user");
%>
<%
	User profile = (User) request.getAttribute("profile");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>

</head>
<body>

	<h1 style="text-align: center;"><%=profile.getID()%></h1>


	<%
		// if admin, allow option to change admin setting or delete profile
		if (user.isAdmin()) {
			// button to delete user
			out.println("<form action='RemoveUserServlet' method='post'>"
					+ "<input type='submit' value='Delete User' />"
					+ "<input type='hidden' name='target' value='" + profile.getID()
					+ "'>" + "</form>");
			// remove admin 
			if (profile.isAdmin()) {
				out.println("<form action='SetAdminServlet' method='post'>"
						+ "<input type='submit' value='Remove Admin Privileges' />"
						+ "<input type='hidden' name='target' value='"
						+ profile.getID() + "'>"
						+ "<input type='hidden' name='bool' value='false'>"
						+ "</form>");
			}
			// grant admin
			else if (!profile.isAdmin()) {
				out.println("<form action='SetAdminServlet' method='post'>"
						+ "<input type='submit' value='Grant Admin Privileges' />"
						+ "<input type='hidden' name='target' value='"
						+ profile.getID() + "'>"
						+ "<input type='hidden' name='bool' value='true'>"
						+ "</form>");
			}
		}

		// option to send message
		out.println("<form action='CreateMessageServlet' method='post'>"
				+ "<input type='submit' value='Send Message' />"
				+ "<input type='hidden' name='target' value='" + profile.getID()
				+ "'>" + "</form>");

		// check if they are already friends. offer option to remove friend and send challenge
		boolean areFriends = user.getFriends().contains(profile.getID());
		if (areFriends) {

			// remove friend
			out.println("<form action='RemoveFriendServlet' method='post'>"
					+ "<input type='submit' value='Remove Friend' />"
					+ "<input type='hidden' name='target' value='" + profile.getID()
					+ "'>" + "</form>");
		}

		// check if a friend request has been offered
		else if (user.hasRequestFrom(profile.getID())) {
			// accept friend request
			out.println("<form action='AcceptFriendServlet' method='post'>"
					+ "<input type='submit' value='Accept Friend Request' />"
					+ "<input type='hidden' name='target' value='" + profile.getID()
					+ "'>" + "</form>");
			// decline friend request
			out.println("<form action='RemoveFriendServlet' method='post'>"
					+ "<input type='submit' value='Decline Friend Request' />"
					+ "<input type='hidden' name='target' value='" + profile.getID()
					+ "'>" + "</form>");
		}

		// check if a friend request has already been sent
		else if (profile.hasRequestFrom(user.getID())) {
			out.println("<p style='font-style:italic;'>You've already sent a friend request</p>");
		}

		// offer to send friend request
		else {
			out.println("<form action='RequestFriendServlet' method='post'>"
					+ "<input type='submit' value='Send Friend Request' />"
					+ "<input type='hidden' name='target' value='"
					+ profile.getID()
					+ "'>" + "</form>");
		}

		
		//show user information

			// list quizzes this user has created
			out.println("<h3>" + profile.getID() + "'s quizzes</h2>");
			ArrayList<Quiz> quizzes = profile.getQuizzes();
			for (Quiz q : quizzes) {
				out.println(q.getQuizId() + "<br>");
			}

			// list achievements
			out.println("<h3>" + profile.getID() + "'s achievements</h2>");
			ArrayList<Achievement> achievements = profile.getAchievements();
			for (Achievement a : achievements) {
				out.println(a.toString());
			}

			// list history
			out.println("<br><h3>" + profile.getID() + "'s history</h2>");
			History h = profile.getHistory();
			out.println(h.toString());

	%>

	<br>

	<form style='text-align: center;' action="HomeServlet" method="post">
		<input type="submit" value="Home" />
	</form>

</body>
</html>