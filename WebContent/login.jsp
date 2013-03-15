<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizzombie</title>
</head>
<body>

<%@ include file="header_partial.jsp" %>
<h1>Welcome to Quizzombie</h1>
<p>Please log in.</p>
<form action="LoginServlet" method="post">
	User Name: <input type="text" name="username" /><br><br>
	Password: <input type="text" name="password" />
	<input type="submit" value="Login" /><br><br>
</form>
<a href="/myproj/account_creation.jsp">Create New Account</a> 
<%@include file="content_end_partial.jsp" %>
</body>
</html>