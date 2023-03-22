<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1>
<form:form method="POST" action="/registration" modelAttribute="user">
    Новый Username <form:input path="username"/><br/>
    Пароль<form:input path="password"/><br/>
    <input type="submit"><br/>
</form:form>
<a href="/login">Вход</a>
</body>
</html>
