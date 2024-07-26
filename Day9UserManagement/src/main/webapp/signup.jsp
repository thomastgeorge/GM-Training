<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
</head>
<body>
	<h2>User Registration Form</h2>
    <form action="UserManagementServlet">
        <label for="uname">Name:</label>
        <input type="text" id="uname" name="uname" required><br><br>
        
        <label for="uemail">Email:</label>
        <input type="email" id="uemail" name="uemail" required><br><br>
        
        <label for="upswd">Password:</label>
        <input type="password" id="upswd" name="upswd" required><br><br>
        
        <label for="uphno">Phone Number:</label>
        <input type="tel" id="uphno" name="uphno" required><br><br>
        
        <input type="submit" value="Submit">
</body>
</html>