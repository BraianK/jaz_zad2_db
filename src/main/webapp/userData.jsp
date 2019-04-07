<%--
  Created by IntelliJ IDEA.
  User: Braian
  Date: 07.04.2019
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
 Dane użytkownika
            <form action="" method="POST">
                Imię:<input readonly="readonly" type="text" id="name" name="name" value="${userData.name}"/>
                Login:<input readonly="readonly" type="text" id="login" name="login" value="${userData.login}"/>
                Email<input readonly="readonly" type="text" id="email" name="email" value="${userData.email}"/>
            </form>
</body>
</html>