<%--
  Created by IntelliJ IDEA.
  User: aprozorov
  Date: 05.02.2019
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
        Login: <input type="text" name="login"><br>
        Password: <input type="text" name="password"><br>
        <input type="submit" value="Sign In">
    </form>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
        <input type="submit" value="Sign in as guest" name="guest" value="true" >
    </form>
</body>
</html>
