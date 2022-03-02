<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/27/22
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Отличные туры</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Весь спектор туров отдыха в грузии представлен тут!</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Тип отдыха</th>
        <th>Город</th>
        <th>Дата</th>
        <th>Дней</th>
        <th>Питание</th>
        <th>Цена</th>
        <th>Тип трансфера</th>
        <th>edit</th>
        <th>Order</th>

        <td>&nbsp;</td>
    </tr>
    <c:forEach var="tour" items="${tours}">
        <tr>
            <td class="content">${tour.id}</td>
            <td class="content">${tour.typeOfHoliday}</td>
            <td class="content">${tour.town}</td>
            <td class="content">${tour.date}</td>
            <td class="content">${tour.day}</td>
            <td class="content">${tour.food.name}</td>
            <td class="content">${tour.price}</td>
            <td class="content">${tour.transfer}</td>
            <td class="empty"><a href="tourEdit.html?id=${tour.id}" class="edit"></a></td>
            <td class="empty"><a href="/order/add.html?id=${tour.id}" class="add-button">ЗАКАЗАТЬ</a></td>
        </tr>
    </c:forEach>
</table>
<a href="MyController?command=GoToTourSaveCommand" class="add-button">Добавить</a>
</body>
</html>

