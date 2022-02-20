<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/17/22
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Виды транспорта на отдыхе</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Разновидности транспорта</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Вид транспорта</th>
        <td>&nbsp;</td>
    </tr>
    <c:forEach var="transfer" items="${transfers}">
        <tr>
            <td class="content">${transfer.id}</td>
            <td class="content">${transfer.typeOfTransport}</td>
            <td class="empty"><a href="MyController?command=GoToTransferEdit&id=${transfer.id}" class="add-button">Редактировать</a></td>
                <%--                <td class="empty"><a href="userEdit.jsp?id=${user.id}" class="edit"></a></td>--%>
        </tr>
    </c:forEach>
</table>
<a href="transferEdit.jsp" class="add-button">Добавить</a>
</body>
</html>
