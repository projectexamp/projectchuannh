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
		<div>
			<form method="POST" action="/role/search">
				<label>Tìm kiếm: </label> <input type="text" name="searchTxt">
				<button>Tìm</button>
			</form>
		</div>
		<div>
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
						<td><c:choose>
								<c:when test="${lts.status=='0' }">
								Mới
							</c:when>
								<c:when test="${lts.status=='1' }">
								Ẩn
							</c:when>
								<c:otherwise>
								Xóa
							</c:otherwise>
							</c:choose></td>
						<td><a href="<c:url value='/role/update/${lts.id }'/>">Sửa</a>
							&nbsp; <a onclick="return confirm('Chắc Chắn Muốn Xóa')"
							href="<c:url value='/role/delete/${lts.id }'/>">Xóa</a> &nbsp; <a
							href="<c:url value='/role/disable/${lts.id }'/>">Ẩn</a> &nbsp; <a
							href="<c:url value='/role/active/${lts.id }'/>">Kích hoạt</a>
							&nbsp; <a href="<c:url value='/role/assignFunc/${lts.id }'/>">Gán
								chức năng</a></td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>