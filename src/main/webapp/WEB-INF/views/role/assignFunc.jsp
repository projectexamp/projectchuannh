<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Gán chức năng</title>
</head>
<body>
	<div align="center">
		<h3>Gán chức năng</h3>
		<form:form action="/role/assignFnToRole" method="POST"
			modelAttribute="rf">
			<table>
				<tr>
					<td><form:checkboxes items="${list }" path="functions" /></td>
				</tr>
				<tr>
					<td><form:button>Lưu</form:button></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>