<%--
  Created by IntelliJ IDEA.
  User: Kejam
  Date: 1/9/2019
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:forEach var="user" items="${Users}" >
        <tr>
            <td>
                    <c:out value="${user.name}"></c:out>
            </td>
            <td>
                    <c:out value="${user.id}"></c:out>
            </td>
            <td>
                    <c:out value="${user.email}"></c:out>
            </td>
            <td>
                    <c:out value="${user.login}"></c:out>
            </td>
            <td>
                    <c:out value="${user.getCreateDat()}"></c:out>
            </td>
            <td>
                    <c:out value="${user.password}"></c:out>
            </td>
            <td>
                    <c:out value="${user.role}"></c:out>
            </td>
            <td>
                <c:if test="${sessionScope.role <= user.role}">
                    <a href="/update?id=${user.getID()}">edit</a>
                </c:if>
                <c:if test="${sessionScope.role == 2}">
                    <a>You haven't enough rights</a>
                </c:if>
            </td>
            <td>
                <c:if test="${sessionScope.role == 0}">
                    <a href="/delete?id=${user.getID()}">delete</a>
                </c:if>
                <c:if test="${sessionScope.role > 0}">
                    <a>You haven't enough rights</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/create" method="get">
     <input type="submit" value="Create User">
</form>
</body>
</html>
