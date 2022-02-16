<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/15/22
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница пользователя</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Персональная страница</h2>
<table>
    <tr>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Почта</th>
        <th>Уровень скидки</th>
        <%--                <th>Роль</th>--%>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td class="content">${user.login}</td>
        <td class="content">${user.password}</td>
        <td class="content">${user.name}</td>
        <td class="content">${user.surname}</td>
        <td class="content">${user.email}</td>x
        <td class="content">${user.discount}</td>


<%--        <td><a href="MainController?command=GoToUserEdit=<c:out value="${user.id}"/>">Редактировать</a>--%>
        <td class="empty"><a href="MyController?command=GoToUserEdit&id=${user.id}" class="add-button">Редактировать</a></td>


        <%--                <td class="empty"><a href="userEdit.jsp?id=${user.id}" class="edit"></a></td>--%>
    </tr>
</table>
</body>
</html>
