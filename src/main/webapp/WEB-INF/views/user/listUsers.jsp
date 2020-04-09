<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Người dùng</title>
</head>
<body>
	<div align="center">
		<h3>Danh sách người dùng</h3>
		<a href="<c:url value='/user/add'/>">Thêm</a>
		<div>
			<form method="POST" action="/user/search">
				<label>Tìm kiếm: </label> <input type="text" name="searchTxt">
				<button>Tìm</button>
			</form>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>STT</th>
					<th>Tên tài khoản</th>
					<th>Tên người dùng</th>
					<th>Giới tính</th>
					<th>Trạng thái</th>
					<th>Action</th>
				</tr>
				<c:set var="count" value="1" />
				<c:forEach items="${list }" var="lts">
					<tr>
						<td><c:out value="${count }"></c:out></td>
						<td>${lts.username }</td>
						<td>${lts.fullName }</td>
						<td>${lts.gender }</td>
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
						<td><a href="<c:url value='/user/update/${lts.id }'/>">Sửa</a>
							&nbsp; <a onclick="return confirm('Chắc Chắn Muốn Xóa')"
							href="<c:url value='/user/delete/${lts.id }'/>">Xóa</a> &nbsp; <a
							href="<c:url value='/user/disable/${lts.id }'/>">Ẩn</a> &nbsp; <a
							href="<c:url value='/user/active/${lts.id }'/>">Kích hoạt</a>
							&nbsp; <a href="<c:url value='/user/assignRole/${lts.id }'/>">Gán
								quyền</a></td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>