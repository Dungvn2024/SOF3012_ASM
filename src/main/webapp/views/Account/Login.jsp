<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    
    <style>
    body {
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #6a11cb, #2575fc);
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #fff;
}

.login-container {
    background: #fff;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
    width: 350px;
    text-align: center;
    color: #333;
}

h1 {
    margin-bottom: 20px;
    font-size: 28px;
    color: #333;
    font-weight: bold;
}

.form-group {
    margin-bottom: 15px;
    text-align: left;
}

label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
    color: #555;
}

input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 6px;
    font-size: 14px;
    box-sizing: border-box;
}

input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

button {
    width: 100%;
    background: #007bff;
    color: #fff;
    border: none;
    border-radius: 6px;
    padding: 12px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background: #0056b3;
}

.error {
    color: red;
    font-size: 14px;
    margin-top: 10px;
}

.links {
    margin-top: 20px;
    display: flex;
    justify-content: space-between;
}

.links a {
    text-decoration: none;
    color: #007bff;
    font-size: 14px;
    transition: color 0.3s;
}

.links a:hover {
    color: #0056b3;
}

.btn-link {
    padding: 8px 12px;
    background: #f0f0f0;
    border-radius: 6px;
    text-decoration: none;
    font-weight: bold;
    color: #333;
    transition: background 0.3s, color 0.3s;
}

.btn-link:hover {
    background: #007bff;
    color: #fff;
}
    
    </style>
    
</head>
<body>
    <div class="login-container">
        <h1>Đăng nhập</h1>
        <form action="/SOF3012_ASM/UserControl" method="post">
            <div class="form-group">
                <label for="idOrEmail">Tên đăng nhập hoặc email:</label>
                <input type="text" id="idOrEmail" name="idOrEmail" required>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Đăng nhập</button>

            <!-- Hiển thị thông báo lỗi -->
            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>
        </form>

        <!-- Các nút "Quên mật khẩu" và "Đăng ký" -->
        <div class="links">
            <a href="/forgot-password" class="btn-link">Quên mật khẩu?</a>
            <a href="/register" class="btn-link">Đăng ký</a>
        </div>
    </div>
</body>
</html>
