<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Challenge Sent</title>
</head>
<body>
<h1 style='text-align:center;'><%= "Your challenged " + request.getParameter("target") + " to take the quiz " + request.getParameter("quiz")%> </h1>

<p style='text-align:center;'>
	<%=request.getParameter("txt") %>
</p>

<br>
<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>

</body>
</html>