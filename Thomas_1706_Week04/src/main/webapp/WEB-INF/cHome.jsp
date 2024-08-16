<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - IMART</title>
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
        .btn-order {
            background-color: #007BFF;
        }
        .btn-view-order {
            background-color: #007BFF;
        }
        .btn-delete {
            background-color: #DC3545;
        }
        .btn-update {
            background-color: #FFC107;
        }
        .error {
            color: #FF6347;
            margin-top: 10px;
        }
        .login-container {
            margin-top: 20px;
        }
        .button-row {
            display: flex;
            justify-content: center;
            margin-bottom: 20px; /* Add spacing between rows if needed */
        }
        .button-row form {
            margin: 0 10px; /* Add spacing between buttons */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>${cname},</h1>
        <h1>Welcome to IMART</h1>
        <h6>where the world comes to shop</h6>
        
        <div class="button-row">
            <form action="cOrder" method="post">
                <button type="submit" class="btn btn-order">Order</button>
            </form>
            <form action="cViewOrder" method="post">
                <button type="submit" class="btn btn-view-order">View Order</button>
            </form>
            <form action="cDeleteOrder" method="post">
                <button type="submit" class="btn btn-delete">Delete Order</button>
            </form>
        </div>

        <div class="button-row">
            <form action="cUpdateName" method="post">
                <button type="submit" class="btn btn-update">Update Name</button>
            </form>
            <form action="cDeleteAccount" method="post">
                <button type="submit" class="btn btn-delete">Delete Account</button>
            </form>
        </div>
    </div>
</body>
</html>
