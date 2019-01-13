<%--
  Created by IntelliJ IDEA.
  User: Kejam
  Date: 1/9/2019
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.validate.ValidateService" %>
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
            Password
        </th>
        <th>
            Role
        </th>
        <th>
            Update
        </th>
        <th>
            Delete
        </th>
    </tr>
    <c:forEach items="${Users}" var="user">
        <tr>
            <td>
                    <c:out value="${user.name}"></c:out>
            </td>
            <td>
                    <c:out value="${user.getID()}"></c:out>
            </td>
            <td>
                    <c:out value="${user.email}"></c:out>
            </td>
            <td>
                    <c:out value="${user.login}"></c:out>
            </td>
            <td>
                    <c:out value="${user.createDate}"></c:out>
            </td>
            <td>
                <c:out value="${user.password}"></c:out>
            </td>
            <td>
                <c:out value="${user.role}"></c:out>
            </td>
            <td>
                <c:if test="${user.role < 2}">
                    <c:if test="${sessionScope.get(role) <= user.role}">
                    <a href="/WEB-INF/views/update.jspews/update.jsp?id=${user.getID()}">edit</a>
                    </c:if>
                </c:if>
                    <c:if test="${user.role == 2}">
                    <a>You haven't enough rights</a>
                    </c:if>
            </th>
            <th>
                <c:if test="${user.role == 0}">
                <a href="/delete?id=${user.getID()}">delete</a>
                </c:if>
                <c:if test="${user.role > 0}">
                    <a>You haven't enough rights</a>
                </c:if>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
