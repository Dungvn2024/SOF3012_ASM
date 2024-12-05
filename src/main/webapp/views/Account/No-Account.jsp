<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/CSS/Login.css">
</head>
<body>
    <div class="login-container">
        <h1>Forgot Password</h1>
        <form action="${pageContext.request.contextPath}/forgot-password" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your registered email" required>
            </div>
            <button type="submit">Reset Password</button>
            <div class="error">
                ${error != null ? error : ""}
            </div>
        </form>
    </div>
</body>
</html>