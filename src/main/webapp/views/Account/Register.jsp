<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f4f4f9;
    }
    h1 {
        color: #333;
    }
    form {
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 400px;
        margin: auto;
    }
    form input, form select {
        display: block;
        width: 100%;
        margin-bottom: 10px;
        padding: 6px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    form button {
        background-color: #007bff;
        color: #fff;
        padding: 8px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-right: 5px;
    }
    form button:hover {
        background-color: #0056b3;
    }
    i {
        display: block;
        margin-bottom: 20px;
        color: red;
        text-align: center;
    }
</style>
</head>
<body>
    <h1>User Registration</h1>
    <i>${message}</i>
    <form action="/SOF3012_ASM/signin" method="post">
        <label>ID:</label>
        <input name="id" type="text" required>
        
        <label>Fullname:</label>
        <input name="fullname" type="text" required>
        
        <label>Password:</label>
        <input name="password" type="password" required>
        
        <label>Confirm Password:</label>
        <input name="confirmPassword" type="password" required>
        
        <label>Email:</label>
        <input name="email" type="email" required>
        
        <label>Role:</label>
        <select name="admin">
            <option value="false">User</option>
            <option value="true">Admin</option>
        </select>
        
        <button formaction="${url}/create">Đăng Ký</button>
    </form>
</body>
</html>

