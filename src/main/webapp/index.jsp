<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello, world</h1>

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
			<td>Address</td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td>Contact No</td>
			<td><input type="text" name="contact" /></td>
		</tr></table>
	<input type="submit" value="Submit" /></form>



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
	<input type="submit" value="Submit" /></form>
</body>
</body>
</html>