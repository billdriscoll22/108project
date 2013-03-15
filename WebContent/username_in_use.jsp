<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">
<title>Create Account</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<h1>The Name <%= request.getParameter("username") %> Is Already In Use</h1>
<p>Please enter another name and password.</p>
<form action="AccountCreationServlet" method="post">
	User Name: <input type="text" name="username" /><br><br>
	Password: <input type="text" name="password" />
	<input type="submit" value="Login" /><br><br>
</form>
<%@include file="content_end_partial.jsp" %>

</body>
</html>