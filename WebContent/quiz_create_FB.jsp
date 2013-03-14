<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Fill In The Blank Question</title>
</head>
<body>
<h1>Add Fill In The Blank Question</h1>

<form action="QuizCreateServlet" method="post">
Enter text before blank: 
<textarea name="beforeText"></textarea><br><br>

Enter text after blank: 
<textarea name="afterText"></textarea><br><br>
  
Possible correct answers (separated by ":"): <input type="text" name="questionAnswer"><br><br>

<input type="submit" name="init" value="Add FIB Response"><br><br>
<input type="submit" name="init" value="Cancel Question">
</form>

</body>
</html>