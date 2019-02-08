<%--
  Created by IntelliJ IDEA.
  User: aprozorov
  Date: 05.02.2019
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update car</title>
</head>
<body>
<form action="/update" method="post">
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        ID: <input type="text" name="id" value="${id}"><br>
        Name: <input type="text" name="name" value="name"><br>
        Description: <input type="text" name="email" value="email"><br>
        Sale: <input type="text" name="login" value="login"><br>
        Name car: <input type="text" name="namecar" value="namecar"><br>
        Engine:
        <select name="engine">
            <option value="0">Petrol</option>
            <option value="1">Diesel</option>
        </select>
        Carbody:
        <select name="carBody">
            <option value="0">Hatchback</option>
            <option value="1">Sedan</option>
            <option value="2">Wagon</option>
        </select>
        Transmission:
        <select name="transmission">
            <option value="0">Automatic</option>
            <option value="1">Mechanics</option>
        </select>
        Status: <input type="text" name="status" value="true
"><br>
        Color: <input type="text" name="color" value="color"><br>
        Image: <input type="file" name="image"><br/>
        <input type="submit" value="create">
    </form>
</form>
</body>
</html>
