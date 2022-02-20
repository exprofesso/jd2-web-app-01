<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/17/22
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вида транспорта</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Добавление транспорта</h2>
<form action="MyController" method="get">
    <input type="hidden" name="command" value="TransferSaveCommand">
    <table style="with: 50%">
        <tr>
            <td>Тип транспорта</td>
            <td><input type="text" name="typeOfTransport" /></td>
        </tr></table>
    <input type="submit" value="Submit" /></form>
</body>
</body>
</html>
