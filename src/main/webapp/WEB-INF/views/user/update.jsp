<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thông tin người dùng</title>
</head>
<body>
	<div align="center">
		<h3>Sửa</h3>
		<form:form action="/user/update" method="POST"
			modelAttribute="oldUser">
			<table>
				<form:hidden path="id" />
				<tr>
					<td><label>Tên người dùng</label></td>
					<td><form:input path="fullName" /></td>
				</tr>
				<tr>
					<td><label>Giới tính</label></td>
					<td><form:radiobutton path="gender" value="0" />Nam
					<form:radiobutton path="gender" value="1" />Nữ
					<form:radiobutton path="gender" value="2" />Khác</td>
				</tr>
				<tr>
					<td><form:button>Sửa</form:button></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>