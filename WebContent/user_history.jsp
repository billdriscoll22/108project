<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, frontend.*, sql.*"%>
    <% User target = (User)request.getAttribute("target"); %>
    <% DB db = (DB)request.getAttribute("db"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History for <%=target.getID() %></title>

</head>
<body>

<h1 style="text-align: center;">History for <%=User.getUserProfileLink(target.getID())%></h1>


<%
//print recent quizzes taken
out.println("<h2>Quizzes Taken</h2>");
ArrayList<Result> results = db.getRecentResults(target.getID(), 100000);
for(Result r : results){
	out.println(r.getPercentCorrect() + "% on " + Quiz.getQuizLink(r.getQuiz()) + " on " + r.getDateTaken() + "</br>");
}

// print recent quizzes made
out.println("<h2>Quizzes Created</h2>");
ArrayList<Quiz> quizzes = db.getRecentQuizzes(target.getID(), 100000);
for(Quiz q : quizzes){
	out.println(q.toLink() + " on " + q.getDateCreated() + "</br>");
}
// print achievements
out.println("<h2>Achievements Earned</h2>");
ArrayList<Achievement> achievement = db.getAchievements(target.getID());
for(Achievement a : achievement){
	out.println(a.toString() + "<br>");
}

%>

<br>
<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Home" />
</form>

</body>
</html>