<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chức năng</title>
</head>
<body>
	<div align="center">
		<h3>Danh sách chức năng</h3>
		<a href="<c:url value='/function/add'/>">Thêm</a>
		<div>
			<form method="POST" action="/function/search">
				<label>Tìm kiếm: </label> <input type="text" name="searchTxt">
				<button>Tìm</button>
			</form>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>STT</th>
					<th>Tên chức năng</th>
					<th>Mã chức năng</th>
					<th>Đường dẫn</th>
					<th>Trạng thái</th>
					<th>Thứ tự SX</th>
					<th>Ghi chú</th>
					<th>Action</th>
				</tr>
				<c:set var="count" value="1" />
				<c:forEach items="${list }" var="lts">
					<tr>
						<td><c:out value="${count }"></c:out></td>
						<td>${lts.functionName }</td>
						<td>${lts.functionCode }</td>
						<td>${lts.functionUrl }</td>
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
						<td>${lts.functionOrder }</td>
						<td>${lts.description }</td>
						<td><a href="<c:url value='/function/update/${lts.id }'/>">Sửa</a>
							&nbsp; <a onclick="return confirm('Chắc Chắn Muốn Xóa')"
							href="<c:url value='/function/delete/${lts.id }'/>">Xóa</a>
							&nbsp; <a href="<c:url value='/function/disable/${lts.id }'/>">Ẩn</a>
							&nbsp; <a href="<c:url value='/function/active/${lts.id }'/>">Kích
								hoạt</a></td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>