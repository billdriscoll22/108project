<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<%@ include file="header_partial.jsp" %>
<h1>You need to create an account to use our app</h1>
<p>Please enter proposed name and password.</p>
<form action="AccountCreationServlet" method="post">
	User Name: <input type="text" name="username" /><br><br>
	Password: <input type="text" name="password" /><br><br>
	Profile Image: <input type="text" name="profileImage" value="Image URL" /> (optional)
	<input type="submit" value="Create" /><br><br>
</form>
<%@include file="content_end_partial.jsp" %>
</body>
</html>