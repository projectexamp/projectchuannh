<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<form action="/login" method="POST">
			<table>
				<tr>
					<td><form:label path="">Tài khoản</form:label></td>
					<td><input type="text" name="username"></input></td>
				</tr>
				<tr>
					<td><form:label path="">Mật khẩu</form:label></td>
					<td><input type="password" name="password"></input></td>
				</tr>
				<tr>
					<td><button type="submit">Đăng nhập</button></td>
				</tr>
					
				
			</table>
			<a href="/user/register">Đăng ký</a> |
			<a href="/user/register">Lấy lại mật khẩu</a> |
			<a href="/user/changePw">Đổi mật khẩu</a>	
		</form>
	</div>
</body>
</html>