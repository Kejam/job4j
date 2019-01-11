<%--
  Created by IntelliJ IDEA.
  User: aprozorov
  Date: 11.01.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    Login: <input type="text" name="login" value="login"><br>
    Password: <input type="text" name="password" value="password"><br>
    <input type="submit" value="Sign In">
</form>
</body>
</html>
