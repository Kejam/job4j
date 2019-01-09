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
            <td>
                ${User.getName()}
            </td>
            <td>
                    ${User.getID()}
            </td>
            <td>
                    ${User.getEmail()}
            </td>
            <td>
                    ${User.getLogin()}
            </td>
            <td>
                    ${User.getDate()}
            </td>
            <td>
                <a href="/update.jsp?id=${User.getID()}">edit</a>
            </th>
            <th>
                <a href="/delete?id=${User.getID()}">delete</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
