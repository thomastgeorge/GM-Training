<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login - IMART</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 100px;
            background-image: url(https://t4.ftcdn.net/jpg/07/56/60/49/360_F_756604959_Oo2T63Q8ZoIjIOh2N5ICvgeL6MGgEiOs.jpg);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat; /* Changed to no-repeat to prevent unwanted tiling */
            color: white;
            margin: 0; /* Ensure no margin on body */
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            background-color: rgba(0, 0, 0, 0.5);
            padding: 20px; /* Adjusted padding for better spacing */
            border-radius: 10px;
            box-sizing: border-box; /* Ensure padding does not affect width */
        }
        h1 {
            margin-bottom: 20px; 
            font-size: 2.5em;
            color: #7CFC00;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input {
            width: calc(100% - 20px);
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
            font-size: 16px;
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
            margin: 10px 0;
        }
        .btn-submit {
            background-color: #007BFF;
        }
        .btn-signup {
            background-color: #28A745;
        }
        .error {
            color: #FF6347;
            margin-top: 10px;
        }
        .signup-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login to IMART (Admin)</h1>
        <form id="loginForm" action="aDoLogin" method="post" onsubmit="return validateForm()">
            <label for="email">Email:</label>
            <input type="email" id="cemail" name="aemail" required>
            
            <label for="password">Password:</label>
            <input type="password" id="cpwd" name="apwd" required>
            
            <button type="submit" class="btn btn-submit">Login</button>
            
            <div id="errorMessages" class="error"></div>
        </form>

    </div>

    <script>
        function validateForm() {
            let email = document.getElementById("cemail").value;
            let password = document.getElementById("cpwd").value;
            let errorMessages = "";

            // Email Validation
            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                errorMessages += "Invalid email address.<br>";
            }

            // Password Validation
            let passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
            if (!passwordPattern.test(password)) {
                errorMessages += "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character.<br>";
            }

            if (errorMessages) {
                document.getElementById("errorMessages").innerHTML = errorMessages;
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }
    </script>
</body>
</html>
