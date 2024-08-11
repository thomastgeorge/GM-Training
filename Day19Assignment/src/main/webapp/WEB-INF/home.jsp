<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Actions</title>
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
        .form-container {
            display: flex;
           gap:40px;
            align-items: center;
        }
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 15px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-container">
    <form action="addpost">
        <button type="submit">ADD</button>
    </form>

    <form action="del">
        <button type="submit">DELETE</button>
    </form>

    <form action="getid">
        <button type="submit">Get ID</button>
    </form>

    <form action="upp">
        <button type="submit">UPDATE</button>
    </form>

    <form action="all">
        <button type="submit">Display Data</button>
    </form>
</div>

</body>
</html>
