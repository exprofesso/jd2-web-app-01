<%--
  Created by IntelliJ IDEA.
  User: sergeypodkolzin
  Date: 1/19/22
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="MyController" method="get">
<input type="hidden" name="command" value="Registration">
<table style="with: 50%">
    <tr>
        <td>First Name</td>
        <td><input type="text" name="name" /></td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td><input type="text" name="surname" /></td>
    </tr>
    <tr>
        <td>Login</td>
        <td><input type="text" name="login" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="password" name="password" /></td>
    </tr>
    <tr>
        <td>email</td>
        <td><input type="text" name="email" /></td>
    </tr>
    <tr>
        <td>Discount</td>
        <td><input type="text" name="discount" /></td>
    <tr>
        <td>Role</td>
        <td><input type="text" name="role" /></td>
    </tr></table>
<input type="submit" value="Submit" /></form>
</body>
</html>
