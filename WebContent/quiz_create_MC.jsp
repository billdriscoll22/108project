<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ page import="java.util.*, frontend.*"%>
 <meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Multiple Choice</title>
</head>
<body>
<h1> Add Multiple Choice </h1>

<form action="QuizCreateServlet" method="post">
Enter question text: 
<br>
<textarea name="questionText"></textarea><br><br>
Answer 1: <input type="text" name="mcAnswer0"><br>
Answer 2: <input type="text" name="mcAnswer1"><br>
Answer 3: <input type="text" name="mcAnswer2"><br>
Answer 4: <input type="text" name="mcAnswer3"><br><br>
Correct answer:<br>
<input type="radio" name="correctAnswer" value="mcAnswer0">Answer 1<br>
<input type="radio" name="correctAnswer" value="mcAnswer1">Answer 2<br>
<input type="radio" name="correctAnswer" value="mcAnswer2">Answer 3<br>
<input type="radio" name="correctAnswer" value="mcAnswer3">Answer 4<br>
<input type="submit" name="init" value="Add Multiple Choice"><br><br>
<input type="submit" name="init" value="Cancel Question">
</form>
</body>
</html>