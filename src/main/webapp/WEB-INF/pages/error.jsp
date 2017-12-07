<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<div align="center">
    <c:choose>
        <c:when test="${message != null}">
            <h2>${message}</h2>
        </c:when>
        <c:otherwise>
            <h2>Oops! Something went wrong...</h2>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>