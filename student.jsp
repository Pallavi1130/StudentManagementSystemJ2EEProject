<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<FORM action="insert" method="post">
<h1>STUDENT PAGE</h1>
<label>Name:</label>
<input type="text" name="sname"><br>
<label>Subject:</label>
<input type="text" name="sub"><br>
<label>Gender:</label>
<input type="radio" name="gender" value="male">
<label>Male</label>
&nbsp;
<input type="radio" name="gender" value="female">
<label>Female</label>
&nbsp;
<br>
<label>Email:</label>
<input type="email" name="semail"><br>

<label>Education:</label>
<input type="text" name="education"><br>

<input type="submit" name="INSERT"><br>
</FORM>
</body>
</html>