<%--
  Created by IntelliJ IDEA.
  User: Kejam
  Date: 1/9/2019
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<form action="/update" method="post">
    ID: <input type="text" name="id" value="1"><br>
    Name: <input type="text" name="name" value="name"><br>
    Email: <input type="text" name="email" value="email"><br>
    Login: <input type="text" name="login" value="login"><br>
    <input type="submit" value="update">
</form>
</body>
</html>
