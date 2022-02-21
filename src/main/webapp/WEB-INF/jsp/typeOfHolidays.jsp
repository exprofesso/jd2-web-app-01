<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/21/22
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Виды отдыха</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Разновидности отдыха</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Вид отдыха</th>
        <td>&nbsp;</td>
    </tr>
    <c:forEach var="typeOfHoliday" items="${typeOfHolidays}">
        <tr>
            <td class="content">${typeOfHoliday.id}</td>
            <td class="content">${typeOfHoliday.typeOfHoliday}</td>
            <td class="empty"><a href="MyController?command=GoToTypeOfHolidayEdit&id=${typeOfHoliday.id}" class="add-button">Редактировать</a></td>
                <%--                <td class="empty"><a href="userEdit.jsp?id=${user.id}" class="edit"></a></td>--%>
        </tr>
    </c:forEach>
</table>
<a href="typeOfHolidayEdit.jsp" class="add-button">Добавить</a>
</body>
</html>
