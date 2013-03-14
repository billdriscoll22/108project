<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Picture Question</title>
</head>
<body>
<h1>Add Picture Question</h1>

<form action="QuizCreateServlet" method="post">
Enter question text: 
<br>
<textarea name="questionText"></textarea><br><br>
Enter Picture URL:<br>
<input type="text" name="uploadField" /><br><br>
<!--
Choose an image file to upload:<br>
<input type="file" name="uploadField" /><br><br>
  -->
  
Possible correct answers (separated by ":"): <input type="text" name="questionAnswer"><br><br>
<input type="submit" name="init" value="Add Picture Response"> <br><br>
<input type="submit" name="init" value="Cancel Question">
</form>

</body>
</html>