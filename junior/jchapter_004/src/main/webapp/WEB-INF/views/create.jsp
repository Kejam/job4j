<%--
  Created by IntelliJ IDEA.
  User: Kejam
  Date: 1/9/2019
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<c:set var="role" scope="session" value="${sessionScope.get(role)}"/>
<c:if test="${role = 0}">
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    Name: <input type="text" name="name" value="name"><br>
    Email: <input type="text" name="email" value="email"><br>
    Login: <input type="text" name="login" value="login"><br>
    Password: <input type="text" name="password" value="password"><br>
    <select name="roles">
        <option value="0">Administrator</option>
        <option value="1">Manager</option>
        <option value="2">User</option>
    </select>
    <input type="text" name="role" value="${roles}">
    <input type="submit" value="create">
</form>
</c:if>
</body>
</html>
