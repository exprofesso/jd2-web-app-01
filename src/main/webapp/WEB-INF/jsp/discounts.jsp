<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/25/22
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Все скидки тут!</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Все скидки тут!</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Все скидки тут!</th>
        <td>&nbsp;</td>
    </tr>
    <c:forEach var="discount" items="${discounts}">
        <tr>
            <td class="content">${discount.id}</td>
            <td class="content">${discount.percent}</td>
            <td class="empty"><a href="MyController?command=GoToDiscountEdit&id=${discount.id}" class="add-button">Редактировать</a></td>
        </tr>
    </c:forEach>
</table>
<a href="discountEdit.jsp" class="add-button">Добавить</a>
</body>
</html>
