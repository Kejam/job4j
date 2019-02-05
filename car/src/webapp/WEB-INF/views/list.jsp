<%--
  Created by IntelliJ IDEA.
  User: aprozorov
  Date: 05.02.2019
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List cars</title>
</head>
<body>
    <h1>List cars</h1>
    <table color="black" border="1" >
        <tr>
            <th>
                ID
            </th>
            <th>
                Name
            </th>
            <th>
                Car
            </th>
            <th>
                User
            </th>
            <th>
                Description
            </th>
            <th>
                Sale
            </th>
            <th>
                Status
            </th>
            <th>
                Photo
            </th>
            <th>
                Update
            </th>
        </tr>
        <c:forEach var="ad" items="${Ads}" >
            <tr>
                <td>
                    <c:out value="${ad.id}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.name}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.user}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.car}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.description}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.sale}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.status}"></c:out>
                </td>
                <td>
                    <c:out value="${ad.photo}"></c:out>
                </td>
                <td>
                    <c:if test="${sessionScope.login <= ad.user.login}">
                        <a href="/update?id=${ad.id}">edit</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
