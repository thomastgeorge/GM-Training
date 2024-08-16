<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home - IMART</title>
    <style>
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
            margin-bottom: 20px;
            font-size: 2.5em;
            color: #7CFC00;
        }
        .btn-container {
        	margin-top: 30px;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 10px;
            margin-bottom: 20px;
        }
        .btn-container .btn {
            font-size: 16px;
            padding: 10px 20px;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            background-color: #007BFF; /* Default color, can be overridden */
        }
        .btn-container .btn:nth-child(1) {
            background-color: #007BFF; /* View All Customers */
        }
        .btn-container .btn:nth-child(2) {
            background-color: #007BFF; /* View All Orders */
        }
        .btn-container .btn:nth-child(3) {
            background-color: #007BFF; /* Delete Customer */
        }
        .btn-container .btn:nth-child(4) {
            background-color: #FF5733; /* Delete Order */
        }
        .btn-container .btn:nth-child(5) {
            background-color: #FF5733; /* View Order by Id */
        }
        .btn-container .btn:nth-child(6) {
            background-color: #FF5733; /* Update Customer Name */
        }
        .error {
            color: #FF6347;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Home - IMART</h1>
        <div class="btn-container">
            <form action="aViewAllCustomers" method="get">
                <button type="submit" class="btn">View All Customers</button>
            </form>
            <form action="aViewAllOrders" method="get">
                <button type="submit" class="btn">View All Orders</button>
            </form>
            <form action="aDeleteAccount" method="post">
                <button type="submit" class="btn">Delete Customer</button>
            </form>
        </div>
        <div class="btn-container">
            <form action="aDeleteOrder" method="post">
                <button type="submit" class="btn">Delete Order</button>
            </form>
            <form action="aViewOrderById" method="get">
                <button type="submit" class="btn">View Order by Id</button>
            </form>
            <form action="aUpdateCustomerName" method="post">
                <button type="submit" class="btn">Update Customer Name</button>
            </form>
        </div>
    </div>
</body>
</html>
