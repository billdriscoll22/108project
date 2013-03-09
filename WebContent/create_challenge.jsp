<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send A Challenge</title>
</head>
<body>
<h1 style='text-align:center;'><%= "Challenge " + request.getParameter("target") + " to take a quiz"%></h1>

<p style="text-align:center; color:red; font-style:italic;">
<%
	// present an error message if applicable
	String error = (String)request.getAttribute("error");
	if(error != null){
		out.println(error);
	}
%>
</p>

<form style='text-align:center;' action="SendChallengeServlet" method="post">
Quiz Name: <input type='text' name ='quiz' value='Enter Quiz Name'><br>

Message: <textarea rows='5' cols='30' name='txt'></textarea><br>
<input type="submit" value="Send Message" />
<input type='hidden' name='target' value='<%=request.getParameter("target") %>'>
</form>

<br>
<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>

</body>
