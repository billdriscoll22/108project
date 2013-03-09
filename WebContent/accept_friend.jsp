<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Successfully Added</title>
</head>
<body>
<h1 style='text-align:center;'><%= (String)request.getParameter("target") %> was added to your friend list!</h1>

<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Return Home" />
</form>

</body>
</html>