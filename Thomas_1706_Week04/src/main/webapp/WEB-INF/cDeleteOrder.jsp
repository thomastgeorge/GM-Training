<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Order - IMART</title>
    <style>
        /* Existing CSS */
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 100px;
            background-image: url(https://t4.ftcdn.net/jpg/07/56/60/49/360_F_756604959_Oo2T63Q8ZoIjIOh2N5ICvgeL6MGgEiOs.jpg);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: white;
            margin: 0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: rgba(0, 0, 0, 0.5);
            padding: 20px;
            border-radius: 10px;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h1 {
            margin-bottom: 10px;
            font-size: 2.5em;
            color: #7CFC00;
        }
        h6 {
            margin-top: 0;
            font-size: 1.2em;
            color: #FFFAF0;
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
            display: inline-block;
        }
        .btn-delete {
            background-color: #FF4C4C;
            margin: 20px 10px;
        }
        .btn-home {
            background-color: #007BFF;
            margin: 20px 10px;
        }
        .button-row form {
            margin: 0 10px;
        }
        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Delete Order</h1>
        
        <form action="cDoDeleteOrder" method="post">
            <input type="text" name="oid" placeholder="Enter Order ID to delete" required>
            <button type="submit" class="btn btn-delete">Delete Order</button>
        </form>
        
        <form action="cHome" method="post">
                <button type="submit" class="btn btn-home">Home</button>
		</form>
    </div>
</body>
</html>
