<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User CRUD</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f4f4f9;
    }
    h1 {
        color: #333;
    }
    i {
        display: block;
        margin-bottom: 20px;
        color: #007bff;
    }
    form {
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 400px;
        margin-bottom: 20px;
    }
    form input[type="text"],
    form input[type="password"],
    form input[type="radio"] {
        display: block;
        width: 40%;
        margin-bottom: 0px;
        padding: 6px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    form input[type="radio"] {
        width: auto;
        display: inline-block;
        margin-right: 5px;
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
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #fff;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #007bff;
        color: #fff;
    }
    tbody tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tbody tr:hover {
        background-color: #f1f1f1;
    }
    a {
        color: #007bff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
    
    nav {
            background-color: #333;
            padding: 10px;
        }

        nav a {
            color: white;
            margin: 0 10px;
            text-decoration: none;
        }

        nav a:hover {
            text-decoration: underline;
        }
</style>
</head>
<body>
<%@ include file="nav.jsp" %>
<i>${message}</i>
<c:url var="url" value="/user/crud"/>
	<form method="post">
		<label>id:</label> <br>
		    <input name="id" value="${user.id}"><br>
		<label>fullname:</label> <br>
		    <input name="fullname" value="${user.fullname}"><br>
		<label>password:</label> <br>
		    <input name="password" type="password" value="${user.password}"><br>
		<label>email:</label> <br>
		    <input name="email" value="${user.email}"><br>
		    <input name="admin" type="radio" value="true" ${user.admin ? 'checked' : ''}> Admin
		    <input name="admin" type="radio" value="false" ${!user.admin ? 'checked' : ''}> User
		    <hr>
			    <button formaction="${url}/create">Create</button>
			    <button formaction="${url}/update">Update</button>
			    <button formaction="${url}/delete">Delete</button>
			    <button formaction="${url}/reset">Reset</button>
	</form>
<hr>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Password</th>
				<th>Fullname</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.id}</td>
				<td>${u.password}</td>
				<td>${u.fullname}</td>
				<td>${u.email}</td>
				<td>${u.admin ? 'Admin' : 'User'}</td>
				<td><a href="${url}/edit/${u.id}">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>