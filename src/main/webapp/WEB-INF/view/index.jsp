<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.edu.bsu.onlinecinema.persistance.dto.SessionDto" %>
<html>
<head>
    <title>Страница пользователя</title>
</head>
<body>
    <h1>Расписание</h1>
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
</body>
</html>
