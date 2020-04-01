<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
</head>
<body>
	<a href="<c:url value="/function/list"/>">Danh sách chức năng</a> |
	<a href="<c:url value="/function/list"/>">Danh sách quyền</a> |
	<a href="<c:url value="/function/list"/>">Danh sách người dùng</a>
	<br>
	<a href="<c:url value="/logout"/>">Đăng xuất</a>
</body>
</html>