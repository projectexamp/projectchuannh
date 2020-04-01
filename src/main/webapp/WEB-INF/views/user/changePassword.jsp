<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đổi mật khẩu</title>
</head>
<body>
	<div align="center">
		<h3>Đổi mật khẩu</h3>
		<form:form method="POST" modelAttribute="user" action="/user/signUp">
			<table>
				<tr>
					<td><form:label path="">Mật khẩu cũ</form:label></td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td><form:label path="">Mật khẩu Mới</form:label></td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td><form:button>Submit</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>