<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Gán quyền</title>
</head>
<body>
	<div align="center">
		<h3>Gán quyền</h3>
		<form:form action="/user/assignRoleToUser" method="POST"
			modelAttribute="ru">
			<table>
				<%-- <tr>
					<td><form:checkboxes items="${list }" path="function"
							itemLabel="functionName" element="li" /></td>
				</tr> --%>
				<tr>
					<td><form:hidden path="user" /></td>
				</tr>
				<tr>
					<td><c:forEach items="${list}" var="item">
							<input type="checkbox" name="roleId" value="${item.id }">
							<label>${item.roleName}</label>
						</c:forEach></td>
				</tr>
				<tr>
					<td><form:button>Lưu</form:button></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>