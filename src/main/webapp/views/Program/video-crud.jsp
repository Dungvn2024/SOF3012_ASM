<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Video Management</title>
</head>
<style>


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
    form input[type="number"],
    form input[type="description"] 
    form input[type="checkbox"]{
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
<c:url var="url" value="/video/crud"/>
<form method="post">
    <label>ID:</label><br>
    <input name="id" value="${video.id}"><br>
    <label>Title:</label><br>
    <input name="title" value="${video.title}"><br>
    <label>Video Code:</label><br>
    <input name="poster" value="${video.poster}"><br>
    <label>Views:</label><br>
    <input name="views" type="number" value="${video.views}"><br>
    <label>Description:</label><br>
    <input name="description" value="${video.description}"><br>
    <label>Active:</label><br>
    <input name="active" type="radio" value="true" ${video.active ? 'checked' : ''}> Active
    <input name="active" type="radio" value="false" ${!video.active ? 'checked' : ''}> Inactive
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
            <th>ID</th>
            <th>Title</th>
            <th>Video Code</th>
            <th>Views</th>
            <th>Description</th>
            <th>Active</th>
            <th>Fix</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="v" items="${videos}">
            <tr>
                <td>${v.id}</td>
                <td>${v.title}</td>
                <td>${v.poster}</td>
                <td>${v.views}</td>
                <td>${v.description}</td>
                <td>${v.active ? 'Active' : 'Inactive'}</td>
                <td><a href="${url}/edit/${v.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>