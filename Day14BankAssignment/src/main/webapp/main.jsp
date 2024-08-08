<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Paisa Bank</title>
    <style>
        /* Reset some default styles */
        body, h1 {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }

        .container {
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 50px;
            margin-top: 10px;
        }

        .button-container {
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .signup {
            background-color: #28a745;
        }

        .login {
            background-color: #007bff;
        }

        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
    <h1>Welcome to Paisa Bank</h1>
    <div class="container" >
        <div class="button-container">
            <button class="btn signup"  onclick="window.location.href='signup.jsp';">Sign Up</button>
            <button class="btn login" onclick="window.location.href='login.jsp';">Login</button>
        </div>
    </div>
</body>
</html>
    