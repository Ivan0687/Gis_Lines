<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<div class="wrapper">
    <div class="content">
        <div class="container">
            <c:choose>
                <c:when test="${message != null}">
                    <h2 class="display-4 text-center mt-5 mb-4">${message}</h2>
                </c:when>
                <c:otherwise>
                    <h2 class="display-4 text-center mt-5 mb-4">Oops! Something went wrong...</h2>
                </c:otherwise>
            </c:choose>
            <hr class="w-50">
            <div class="text-center">
            </div>
        </div>
    </div>
</div>
</body>
</html>