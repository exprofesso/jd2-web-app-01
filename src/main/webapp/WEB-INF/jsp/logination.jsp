<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 1/21/22
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logination</title>
</head>
<body>
<form action="MyController" method="get">
    <input type="hidden" name="command" value="login">
    <table style="with: 50%">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr></table>
    <input type="submit" value="Submit" />

</form>
</body>
</html>
