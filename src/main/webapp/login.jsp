<%--
  Created by IntelliJ IDEA.
  User: Braian
  Date: 07.04.2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
            <form action="login" method="POST">
                   Login:<input type="text" id="login" name="login"/>
                   Hasło:<input type="password" id="password" name="password"/>
                <input type="submit" name="loginButton" value="wyslij">
            </form>
            <c:if test="${not empty errorMessage}">
                   ${errorMessage}
            </c:if>
</body>
</html>