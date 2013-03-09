<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send A Message</title>
</head>
<body>
<h1 style='text-align:center;'><%= "Send a message to " + request.getParameter("target") %></h1>

<form style='text-align:center;' action="SendMessageServlet" method="post">
<textarea rows='10' cols='60' name='txt'></textarea>
<br><input type="submit" value="Send Message" />
<input type='hidden' name='target' value='<%=request.getParameter("target") %>'>
</form>

<br>
<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>

</body>
