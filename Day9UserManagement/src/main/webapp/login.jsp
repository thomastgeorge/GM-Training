<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h2>User Registration Form</h2>
    <form action="UserLoginServlet">
        <label for="uemail">Email:</label>
        <input type="email" id="uemail" name="uemail" required><br><br>
        
        <label for="upswd">Password:</label>
        <input type="password" id="upswd" name="upswd" required><br><br>
        
        <input type="submit" value="Submit">
</body>
</html>