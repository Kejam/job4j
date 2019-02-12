<%--
  Created by IntelliJ IDEA.
  User: aprozorov
  Date: 05.02.2019
  Time: 15:03
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
        Login: <input type="text"  name="login"><br>
        Password: <input type="text" name="password"><br>
        <c:set var = "quest" value = "false" scope="request"/>
        <input type="submit" value="Sign In">
    </form>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
        <c:set var = "quest" value = "true" scope="request"/>
        <c:set var = "login" value = "quest" scope="request"/>
        <c:set var = "password" value = "quest" scope="request"/>
        <input type="submit" value="Sign in as quest">
    </form>
</body>
</html>
