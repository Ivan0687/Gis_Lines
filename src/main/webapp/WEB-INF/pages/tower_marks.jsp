<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 05.12.2017
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tower types</title>
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet">
</head>
<body>
<div align="center">
    <table>
        <caption>Tower marks</caption>
        <tr>
            <th>Mark</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Material</th>
        </tr>
        <c:forEach var="towerMark" items="${marks}">
            <tr>
                <td>${towerMark.mark}</td>
                <td>${towerMark.height}</td>
                <td>${towerMark.weight}</td>
                <td>${towerMark.material}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
