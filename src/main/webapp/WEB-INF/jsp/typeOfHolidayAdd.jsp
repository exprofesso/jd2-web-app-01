<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/21/22
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Виды отдыха</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Добавление вида отдыха</h2>
<form action="MyController" method="get">
    <input type="hidden" name="command" value="TypeOfHolidaySaveCommand">
    <table style="with: 50%">
        <tr>
            <td>Тип транспорта</td>
            <td><input type="text" name="typeOfHoliday" /></td>
        </tr></table>
    <input type="submit" value="Submit" /></form>
</body>
</html>
