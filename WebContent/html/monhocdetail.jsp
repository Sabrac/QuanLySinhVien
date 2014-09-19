<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function onDelete() {
		document.getElementsByName('ref')[0].value = "delete";
		document.getElementById('form').action = "ChuyenNganhProcess.do?submit=true";
		document.getElementById('form').submit();
	}
</script>
</head>
<body>
	<form action="MonHocProcess.do" method="post" id="form">
		<input type="hidden" name="ref" value="update" />
		<input type="hidden" name="id" value="${id}" />
		<table align="center">
			<tr>
				<td>
					ID
				</td>
				<td>
					<c:out value="${monhoc.monHocId}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên môn học
				</td>
				<td>
					<c:out value="${monhoc.tenMonHoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Số trình
				</td>
				<td>
					<c:out value="${monhoc.soTrinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ số chuyên cần
				</td>
				<td>
					<c:choose>
						<c:when test="${monhoc.heSoChuyenCan > 0}">
							<c:out value="${monhoc.heSoChuyenCan}" />
						</c:when>
						<c:otherwise>
							<c:out value="" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Hệ số giữa kỳ
				</td>
				<td>
					<c:choose>
						<c:when test="${monhoc.heSoGiuaKy > 0}">
							<c:out value="${monhoc.heSoGiuaKy}" />
						</c:when>
						<c:otherwise>
							<c:out value="" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Hệ số học kỳ
				</td>
				<td>
					<c:choose>
						<c:when test="${monhoc.heSoHocKy > 0}">
							<c:out value="${monhoc.heSoHocKy}" />
						</c:when>
						<c:otherwise>
							<c:out value="" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Chuyên ngành
				</td>
				<td>
					<c:forEach items="${lsChuyenNganh}" var="chuyenNganh">
							<c:choose>
								<c:when test="${chuyenNganh.chuyenNganhId == monhoc.chuyenNganhId}">
										<c:out value="${chuyenNganh.tenChuyenNganh}" />
								</c:when>
								<c:otherwise>
										<c:out value="" />
								</c:otherwise>
							</c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Chỉnh Sửa" name="btnUpdate" />
				</td>
				<td>
					<input type="button" value="Xóa" name="btnDelete" onclick="onDelete();" />
				</td>
				<td>
					<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='MonHoc.do';" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>