<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function onDelete() {
		document.getElementsByName('ref')[0].value = "delete";
		document.getElementById('form').submit();
	}
</script>
</head>
<body>
	<form action="ChuyenNganhProcess.do" method="post" id="form">
		<input type="hidden" value="update" name="ref" />
		<input type="hidden" value="${chuyennganh.chuyenNganhId}" name="id" />
		<table align="center">
			<tr>
				<td>
					Mã Chuyên Ngành
				</td>
				<td colspan="2">
					<c:out value="${chuyennganh.maChuyenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên Chuyên Ngành
				</td>
				<td colspan="2">
					<c:out value="${chuyennganh.tenChuyenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Ngành
				</td>
				<td colspan="2">
					<c:forEach items="${lsNganh}" var="nganh">
						<c:if test="${nganh.nganhId == chuyennganh.nganhId}">
							<c:out value="${nganh.tenNganh}" />
						</c:if>
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
					<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='ChuyenNganh.do';" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>