<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">
<title>Information Incorrect</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<h1>Please Try Again</h1>
<p>Either your user name or password is incorrect. Please try again.</p>
<form action="LoginServlet" method="post">
	User Name: <input type="text" name="username" /><br><br>
	Password: <input type="text" name="password" />
	<input type="submit" value="Login" /><br><br>
</form>
<a href="/myproj/account_creation.jsp">Create New Account</a>
<%@include file="content_end_partial.jsp" %> 
</body>
</html>