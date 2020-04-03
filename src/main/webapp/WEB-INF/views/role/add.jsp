<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm vai trò</title>
</head>
<body>
	<div align="center">
		<h3>Thêm mới</h3>
		<form:form action="/role/add" method="POST" modelAttribute="role">
			<table>
				<tr>
					<td><label>Tên vai trò</label></td>
					<td><form:input path="roleName" /></td>
				</tr>
				<tr>
					<td><label>Mô tả</label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><label>Mã vai trò</label></td>
					<td><form:input path="roleCode" /></td>
				</tr>
				<tr>
					<td><label>Thứ tự sắp xếp</label></td>
					<td><form:select path="roleOrder">
							<!-- chỉ dùng cho String -->
							<%-- <form:option value="NONE" label="Select" /> --%>
							<form:option value="0" label="Thứ 0" />
							<form:option value="1" label="Thứ 1" />
							<form:option value="2" label="Thứ 2" />
							<%-- <form:options items = "${listPosition}" /> --%>
						</form:select></td>
				</tr>
				<tr>
					<td><form:button>Thêm</form:button></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>