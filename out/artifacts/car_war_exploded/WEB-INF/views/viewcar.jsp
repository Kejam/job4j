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
    <title>Title</title>
</head>
<body>
    <c:set var="car" scope="session" value="${sessionScope.car}"/>
    <c:set var="ad" scope="session" value="${sessionScope.ad}"/>
    <h1>Car</h1>
    Name: ${ad.name}
    Name car: ${care.name}
    Description: ${ad.description}
    Color: ${car.colore}
    Engine: ${car.engine}
    Car body: ${car.carBody}
    Transmission: ${car.transmission}
    Status: ${ad.status}
    Price: ${ad.sale}
</body>
</html>
