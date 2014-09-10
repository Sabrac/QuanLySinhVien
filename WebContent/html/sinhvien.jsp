<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<c:if test="showTable == null">
		<table>
			<tr>
				<th>
					MÃ SINH VIÊN
				</th>
				<th>
					HỌ ĐỆM
				</th>
				<th>
					TÊN
				</th>
				<th>
					NGÀY SINH
				</th>
				<th>
					GIỚI TÍNH
				</th>
				<th>
					HỆ ĐÀO TẠO
				</th>
				<th>
					LỚP
				</th>
				<th>
					KHÓA HỌC
				</th>
			</tr>
			<c:forEach items="${lsData}" var="sinhVien">
				<tr>
					<td align="left">
						<c:out value="${sinhVien.maSinhVien}" />
					</td>
					<td align="left">
						<c:out value="${sinhVien.hoDem}" />
					</td>
					<td align="left">
						<c:out value="${sinhVien.ten}" />
					</td>
					<td align="center">
						<fmt:formatDate pattern="yyyy/MM/dd" value="${sinhVien.ngaySinh}" />
					</td>
					<td align="left">
						<c:out value="${sinhVien.gioiTinh}" />
					</td>
					<td align="left">
						<c:forEach items="${lsHdt}" var="hdt">
							<c:if test="${sinhVien.heDtId == hdt.heDtId}">
								<c:out value="${hdt.tenHeDt}" />
							</c:if>
						</c:forEach>
					</td>
					<td align="left">
						<c:forEach items="${lsLop}" var="lop">
							<c:if test="${sinhVien.lopId == lop.lopHocId}">
								<c:out value="${lop.tenLopHoc}" />
							</c:if>
						</c:forEach>
					</td>
					<td align="left">
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
							<c:if test="${sinhVien.khoaHocId == khoaHoc.khoaHocId}">
								<c:out value="${khoaHoc.tenKhoaHoc}" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>