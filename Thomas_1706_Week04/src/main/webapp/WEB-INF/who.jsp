<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IMART</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 200px;
            background-image: url(https://t4.ftcdn.net/jpg/07/56/60/49/360_F_756604959_Oo2T63Q8ZoIjIOh2N5ICvgeL6MGgEiOs.jpg);
            background-size: cover; 
            background-position: center;
            background-repeat: repeat;
            color: white;
        }
        h1 {
            margin-bottom: 10px; 
            font-size: 3em;
            color: #7CFC00;
        }
        h5 {
            margin-top: 0; 
            margin-bottom: 50px;
        }
        .button-container {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 30px; /* Space between tagline and buttons */
        }
        .btn {
            font-size: 16px;
            padding: 10px 20px;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
        }
        .btn-admin {
            background-color: #007BFF;
        }
        .btn-customer {
            background-color: #28A745;
        }
    </style>
</head>
<body>
    <h1>Welcome to IMART</h1>
    <h5>Where the world comes to shop</h5>
    
    <!-- Button Container -->
    <div class="button-container">
        <!-- Admin Button -->
        <form action="aLogin">
            <button type="submit" class="btn btn-admin">Admin</button>
        </form>
        <!-- Customer Button -->
        <form action="cLogin">
            <button type="submit" class="btn btn-customer">Customer</button>
        </form>
    </div>
</body>
</html>
