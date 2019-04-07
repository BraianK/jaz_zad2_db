<%--
  Created by IntelliJ IDEA.
  User: Braian
  Date: 07.04.2019
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
</head>
<body>
            <form action="adminPanel" method="POST">
                <table>
                    <tr>
                        <th>Imię</th>
                        <th>Login</th>
                        <th>Email</th>
                        <th>Premium</th>
                    </tr>
                    <c:forEach items="${userList}" var="element">
                        <tr>
                            <td><input type="text" readonly="readonly"
                                       value="${element.name}"/></td>
                            <td><input type="text" readonly="readonly" name="login"
                                       value="${element.login}"/></td>
                            <td><input type="text" readonly="readonly"
                                       value="${element.email}"/></td>
                            <td><input type="checkbox" name="isPremium"
                                       <c:if test="${element.isPremium}">checked</c:if>
                                       value="${element.login}"><br></td>
                        </tr>
                    </c:forEach>

                </table>
                <input type="submit" name="saveData" value="Zapisz zmiany">
            </form>

</body>
</html>