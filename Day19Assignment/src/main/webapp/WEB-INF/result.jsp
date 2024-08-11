<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h2 {
            color: #333;
        }
        p {
            background-color: #fff;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            color: #555;
            font-size: 18px;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        setTimeout(function() {
            window.location.href = "home";
        }, 3000);
    </script>
</head>
<body>
    <h2>Result</h2>
    <p>${message}</p> 
</body>
</html>
