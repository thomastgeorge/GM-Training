<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Update</title>
</head>
<body>
	<h1>Employee Update</h1><br><br>
	<form action="update/employee" method="post">
		Enter Employee Id: <input type="text" name="id" id="id"> <br><br>
		Enter Employee Salary: <input type="text" name="sal" id="sal"> <br><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>