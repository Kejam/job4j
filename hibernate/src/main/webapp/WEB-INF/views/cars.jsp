<%--
  Created by IntelliJ IDEA.
  User: aprozorov
  Date: 04.02.2019
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
    <h2>Cars</h2>
    <table color="black" border="1" >
        <tr>
            <th>
                ID
            </th>
            <th>
                Name
            </th>
            <th>
                Engine
            </th>
            <th>
                Car body
            </th>
            <th>
                Transmission
            </th>
        </tr>
        <c:forEach var="cars" items="${Users}" >
            <tr>
                <td>
                    <c:out value="${user.id}"></c:out>
                </td>
                <td>
                    <c:out value="${user.name}"></c:out>
                </td>
                <td>
                    <c:out value="${user.engine}"></c:out>
                </td>
                <td>
                    <c:out value="${user.carBody}"></c:out>
                </td>
                <td>
                    <c:out value="${user.transmission}"></c:out>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
