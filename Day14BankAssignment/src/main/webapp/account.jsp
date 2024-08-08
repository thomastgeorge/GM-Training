<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .details {
            margin-bottom: 20px;
        }
        .details label {
            display: block;
            margin-bottom: 5px;
        }
        .buttons {
            text-align: center;
            margin-bottom: 20px;
        }
        .buttons button {
            margin: 0 10px;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
        .form-container {
            display: none;
            text-align: center;
            margin-top: 20px;
        }
        .form-container input {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 10px;
            font-size: 16px;
        }
        .form-container input[type="submit"] {
            background-color: #28a745;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
    <script>
        function showForm(action) {
            // Hide all forms
            document.querySelectorAll('.form-container').forEach(form => form.style.display = 'none');
            
            // Show the selected form
            document.getElementById(action).style.display = 'block';
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Account Details</h1>
    
        <div class="details">
            <label for="name">Name:</label>
            <p id="name"><%= request.getAttribute("cname") %></p>
        </div>
        <div class="details">
            <label for="accno">Account Number:</label>
            <p id="accno"><%= request.getAttribute("accno") %></p>
        </div>
        <div class="details">
            <label for="accountType">Account Type:</label>
             <p id="accountType"><%= request.getAttribute("accountType") %></p>
        </div>
        <div class="details">
            <label for="balance">Balance:</label>
            <p id="balance"><%= request.getAttribute("balance") %></p>
        </div>

        <div class="buttons">
            <button onclick="showForm('withdrawForm')">Withdraw</button>
            <button onclick="showForm('depositForm')">Deposit</button>
            <button onclick="showForm('changePinForm')">Change PIN</button>
        </div>

        <div id="withdrawForm" class="form-container">
            <h2>Withdraw</h2>
            <form action="AccountServlet">
                <input type="number" name="amount" placeholder="Enter amount" required><br>
                <input type="submit" value="Submit">
            </form>
        </div>

        <div id="depositForm" class="form-container">
            <h2>Deposit</h2>
            <form action="AccountServlet">
                <input type="number" name="amount" placeholder="Enter amount" required><br>
                <input type="submit" value="Submit">
            </form>
        </div>

        <div id="changePinForm" class="form-container">
            <h2>Change PIN</h2>
            <form action="AccountServlet">
            	<input type="text" name="oldPin" placeholder="Enter old PIN" required><br>
                <input type="text" name="newPin" placeholder="Enter new PIN" required><br>
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>
