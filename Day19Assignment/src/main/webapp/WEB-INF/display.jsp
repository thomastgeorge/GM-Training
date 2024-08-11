<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 16px;
            color: #555;
        }
    </style>
    <script type="text/javascript">
        setTimeout(function() {
            window.location.href = "home";
        }, 5000);
    </script>
</head>
<body>
    <div class="container">
        <h2>Result</h2>
        <p>ID: ${message.id}</p>
        <p>Title: ${message.title}</p>
        <p>Content: ${message.content}</p>
        <p>Author: ${message.author}</p>
    </div>
</body>
</html>
