<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details - IMART</title>
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
        .order-table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        .order-table th, .order-table td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        .order-table th {
            background-color: #007BFF;
            color: white;
        }
        .order-table tr:nth-child(even) {
            background-color:gray;
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
        .btn {
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
        <h1>Order Details</h1>
        
        <table class="order-table">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Customer Name</th>
                    <th>Customer Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${list}">
                    <tr>
                        <td>${customer.cid}</td>
                        <td>${customer.cname}</td>
                        <td>${customer.cemail}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="aHome" method="post">
                <button type="submit" class="btn ">Home</button>
		</form>
    </div>
</body>
</html>
