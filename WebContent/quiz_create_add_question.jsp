<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="java.util.*, frontend.*"%>
<meta http-equiv="Pragma" content="no-cache">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add a question</title>
</head>
<body>
<h1> Add a question </h1>

<form action="QuizCreateServlet" method="post">
What type of question?<br><br>
<input type="radio" name="questionType" value="multipleChoice">Multiple Choice<br>
<input type="radio" name="questionType" value="fillInBlank">Fill in the Blank<br>
<input type="radio" name="questionType" value="questionResponse">Question Response<br>
<input type="radio" name="questionType" value="pictureResponse">Picture Response<br>
<br>
<input type="submit" name="init"  value="Create Question" /><br><br>
<input type="submit" name="init"  value="No More Questions!" />

</form>

</br>
<form style='text-align:center;' action="HomeServlet" method="post">
<input type="submit" value="Cancel" />
</form>

</body>
</html>