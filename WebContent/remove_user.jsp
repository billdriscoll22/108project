<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Removed</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<h1 style='text-align:center;'><%= (String)request.getParameter("target") %> was deleted!</h1>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>
<%@include file="content_end_partial.jsp" %>

</body>
