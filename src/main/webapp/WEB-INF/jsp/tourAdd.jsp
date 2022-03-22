<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 3/2/22
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty Tour}">
    <jsp:useBean id="Tour" class="by.it.webapp.domain.Tour"/>
</c:if>
<c:choose>
    <c:when test="${not empty Tour.id}"><c:set var="title" value="Редактирование данных пользователя"/></c:when>
    <c:otherwise><c:set var="title" value="Добавление нового пользователя"/></c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="../main.css" rel="stylesheet">
</head>
<body>
<h1>Турфирма лучшего отдыха</h1>
<h2>${title}</h2>
<form action="MyController" method="post">
    <input type="hidden" name="command" value="TourSaveCommand">
    <c:if test="${not empty Tour.id}">
        <input name="id" value="${Tour.id}" type="hidden">
    </c:if>
    <label for="typeOfHoliday">Тип:</label>
    <select id="typeOfHoliday" name="typeOfHoliday">
        <c:forEach var="type" items="${typeOfHoliday}">
            <c:choose>
                <c:when test="${type == tour.typeOfHoliday}"><c:set var="selected" value="selected"/></c:when>
                <c:otherwise><c:remove var="selected"/></c:otherwise>
            </c:choose>
            <option value="${type.id}" ${selected}>${type.typeOfHoliday}</option>
        </c:forEach>
    </select>
    <label for="town">Город:</label>
    <input id="town" name="town" value="${tour.town}">
    <label for="date">Дата заезда:</label>
    <input id="date" name="date" value="${tour.date}">
    <label for="day">Дней:</label>
    <input id="day" name="day" value="${tour.day}">
    <label for="food">Питание:</label>
    <select id="food" name="food">
        <c:forEach var="food" items="${food}">
            <c:choose>
                <c:when test="${food == tour.food}"><c:set var="selected" value="selected"/></c:when>
                <c:otherwise><c:remove var="selected"/></c:otherwise>
            </c:choose>
            <option value="${food.id}" ${selected}>${food.name}</option>
        </c:forEach>
    </select>
    <label for="price">Цена:</label>
    <input id="price" name="price" value="${tour.price}">
    <c:forEach var="type" items="${transfer}">
        <c:choose>
            <c:when test="${type == tour.transfer}"><c:set var="selected" value="selected"/></c:when>
            <c:otherwise><c:remove var="selected"/></c:otherwise>
        </c:choose>
        <option value="${type.id}" ${selected}>${type.transfer}</option>
    </c:forEach>

    <button class="save" href="MyController?command=GoToTours">Сохранить</button>

    <a class="back" href="MyController?command=GoToTours">Отменить</a>
</form>
</body>
</html>
