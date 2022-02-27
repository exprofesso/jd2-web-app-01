<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 2/25/22
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавляем скидки</title>
</head>
<body>
<h1>Турфирма "Грузинская мечта!"</h1>
<h2>Добавляем скидки</h2>
<form action="MyController" method="get">
    <input type="hidden" name="command" value="DiscountSaveCommand">
    <table style="with: 50%">
        <tr>
            <td>Процент скидки</td>
            <td><input type="text" name="Percent" /></td>
        </tr></table>
    <input type="submit" value="Submit" /></form>
</body>
</html>
