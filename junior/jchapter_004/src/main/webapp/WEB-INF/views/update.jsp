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
<c:if test="${sessionScope.role < 2}">
    <form action="/update" method="post">
        ID: <input type="text" name="id" value="${id}"><br>
        Name: <input type="text" name="name" value="name"><br>
        Email: <input type="text" name="email" value="email"><br>
        Login: <input type="text" name="login" value="login"><br>
        Password: <input type="text" name="password" value="password"><br>
        <c:if test="${sessionScope.role == 0}">
            <select name="role">
                <option value="0">Administrator</option>
                <option value="1">Manager</option>
                <option value="2">User</option>
            </select>
        </c:if>
        <input type="submit" value="update">
    </form>
</c:if>

</body>
</html>
