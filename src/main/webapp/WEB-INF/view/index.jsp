<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.edu.bsu.onlinecinema.persistance.dto.SessionDto" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Страница пользователя</title>
</head>
<body>
    <h1>Расписание</h1>
    <form:form method="POST" action="/filter-film" modelAttribute="filter">
        <form:input path="filmName"/>
        <input type="submit" value="Поиск"><br/>
    </form:form>
    <table border="1">
        <caption>Доступные сеансы</caption>
        <tr>
            <th>Фильм</th>
            <th>Время</th>
            <th>Количество мест</th>
        </tr>
        <c:forEach items="${sessions}" var="session" >
            <tr>
                <td>${session.filmName}</td>
                <td>${session.time}</td>
                <td>${session.placeCount}</td>
            </tr>
        </c:forEach>
    </table>
    <h1>Добро пожаловать ${user}</h1>
    <table border="1">
        <caption>Ваша бронь</caption>
        <tr>
            <th>Фильм</th>
            <th>Время</th>
        </tr>
        <c:forEach items="${orders}" var="order" >
            <tr>
                <td>${order.filmName}</td>
                <td>${order.time}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <form:form method="POST" action="/add-reservation" modelAttribute="reservation">
        Название <form:input path="filmName"/><br/>
        Дата Время<form:input path="time"/>
        <input type="submit" value="Забронировать"><br/>
    </form:form>
    <br/>
</body>
</html>
