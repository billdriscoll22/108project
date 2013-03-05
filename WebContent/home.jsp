<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, frontend.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 	if (session.getAttribute("user") == null) {
		out.println("<meta http-equiv=\"REFRESH\" content=\"2;url=login.html\">");
		out.println("<title> You are not logged in! </title>");
	} else {
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title> Welcome " + ((User)session.getAttribute("user")).getID() + "</title>");
	}
%>
</head>
<body>
<% 	if (session.getAttribute("user") == null) {
		out.println("You are not logged in!");
		out.println("Redirecting to login page...");
	} else {
		out.println("<h1>Welcome <%= ((User)session.getAttribute(\"user\")).getID()</h1>");
	}
%>
</body>
</html>