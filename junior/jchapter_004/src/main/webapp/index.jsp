<%--
  Created by IntelliJ IDEA.
  User: Kejam
  Date: 1/9/2019
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users</title>
</head>
<body>
List users
<table color="black" border="1" >
    <tr>
        <th>
            Name
        </th>
        <th>
            ID
        </th>
        <th>
            Email
        </th>
        <th>
            Login
        </th>
        <th>
            Date
        </th>
        <th>
            Update
        </th>
        <th>
            Delete
        </th>
    </tr>
    <c:forEach var="User" items="${ValidateService.getInstance().findAll()}">
        <tr>
            <th>
                ${User.getName()}
            </th>
            <th>
                    ${User.getID()}
            </th>
            <th>
                    ${User.getEmail()}
            </th>
            <th>
                    ${User.getLogin()}
            </th>
            <th>
                    ${User.getDate()}
            </th>
            <th>
                <form action="/list" method="post">
                    <input type="submit" name="action" value="update">
                    <input type="text" name="id" value="${User.getID()}">
                </form>
            </th>
            <th>
                <form action="/list" method="post">
                    <input type="submit" name="action" value="delete">
                    <input type="text" name="id" value="${User.getID()}>
                </form>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
