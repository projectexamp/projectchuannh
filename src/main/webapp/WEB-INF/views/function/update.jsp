<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sửa chức năng</title>
</head>
<body>
	<div align="center">
		<h3>Sửa</h3>
		<form:form action="/function/update" method="POST"
			modelAttribute="oldFn">
			<table>
				<form:hidden path="id" />
				<tr>
					<td><label>Tên chức năng</label></td>
					<td><form:input path="functionName" /></td>
				</tr>
				<tr>
					<td><label>Đường dẫn</label></td>
					<td><form:input path="functionUrl" /></td>
				</tr>
				<tr>
					<td><label>Mô tả</label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><label>Mã chức năng</label></td>
					<td><form:input path="functionCode" /></td>
				</tr>
				<tr>
					<td><label>Thứ tự sắp xếp</label></td>
					<td><form:select path="functionOrder">
							<!-- chỉ dùng cho String -->
							<%-- <form:option value="NONE" label="Select" /> --%>
							<form:option value="0" label="Thứ 1" />
							<form:option value="1" label="Thứ 2" />
							<form:option value="2" label="Thứ 3" />
							<%-- <form:options items = "${listPosition}" /> --%>
						</form:select></td>
				</tr>
				<tr>
					<td><form:button>Sửa</form:button></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>