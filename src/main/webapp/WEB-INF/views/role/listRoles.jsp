<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vai trò</title>
</head>
<body>
	<div align="center">
		<h3>Danh sách vai trò</h3>
		<a href="<c:url value='/role/add'/>">Thêm</a>
		<table border="1">
			<tr>
				<th>STT</th>
				<th>Tên vai trò</th>
				<th>Mô tả</th>
				<th>Mã vai trò</th>
				<th>Thứ tự sx</th>
				<th>Trạng thái</th>
				<th>Action</th>
			</tr>
			<c:set var="count" value="1" />
			<c:forEach items="${list }" var="lts">
				<tr>
					<td><c:out value="${count }"></c:out></td>
					<td>${lts.roleName }</td>
					<td>${lts.description }</td>
					<td>${lts.roleCode }</td>
					<td>${lts.roleOrder }</td>
					<td>${lts.status }</td>
					<td><a href="<c:url value='/role/update/${lts.id }'/>">Sửa</a>
						&nbsp; <a href="<c:url value='/role/delete/${lts.id }'/>">Xóa</a>
						&nbsp; <a href="<c:url value='/role/disable/${lts.id }'/>">Ẩn</a>
						&nbsp; <a href="<c:url value='/role/active/${lts.id }'/>">Kích
							hoạt</a></td>
				</tr>
				<c:set var="count" value="${count + 1}"></c:set>
			</c:forEach>
		</table>
	</div>

</body>
</html>