<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Add</title>
</head>
<body>
	<h1>Add Employee</h1>
	<form action="add/employee" method="post">
		Employee Id: <input type="text" name="id" id="id"> <br><br>
		Employee Name: <input type="text" name="name" id="name"> <br><br>
		Employee Salary: <input type="text" name="sal" id="sal"> <br><br>
		<input type="submit" value="add">
	</form>
</body>
</html>