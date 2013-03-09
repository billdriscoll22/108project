<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Privileges Changed</title>
</head>
<body>
<h1 style='text-align:center;'><%= request.getParameter("target") %> 
<%
if(request.getParameter("bool").equals("true"))
	out.println(" was granted admin privileges.");
else
	out.println(" had their admin privileges removed.");
%>
</h1>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>

</body>
</html>