<%--
  Created by IntelliJ IDEA.
  User: Braian
  Date: 07.04.2019
  Time: 12:42
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
            <form action="registration" method="POST">
                    Name:<input  type="text" id="name" name="name"/>
                    Login:<input type="text" id="login" name="login"/>
                    Email:<input type="text" id="email" name="email"/>
                    Hasło:<input type="password" id="password" name="password"/>
                    Potwierdz hasło:<input type="password" id="passwordConfirm" name="passwordConfirm"/>
                <input type="submit" name="registerButton" value="Wyslij">
            </form>
            <c:if test="${not empty errorMessage}">
            <strong>${errorMessage}</strong>

            </c:if>
</body>
</html>