<%--
  Created by IntelliJ IDEA.
  User: Kejam
  Date: 1/9/2019
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<form action="/create" method="post">
    Name: <input type="text" name="name" value="name"><br>
    Email: <input type="text" name="email" value="email"><br>
    Login: <input type="text" name="login" value="login"><br>
    Password: <input type="text" name="password" value="password"><br>
    <input type="submit" value="create">
</form>
</body>
</html>
