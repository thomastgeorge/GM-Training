<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Add</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="add/addStudent" method="post">
		Student Id: <input type="text" name="id" id="id"> <br><br>
		Student Name: <input type="text" name="name" id="name"> <br><br>
		<input type="submit" value="add">
	</form>
</body>
</html>