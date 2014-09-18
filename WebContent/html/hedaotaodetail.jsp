<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="HeDaoTaoProcess.do" method="post">
		<input type="hidden" value="update" name="ref" />
		<input type="hidden" value="${id}" name="id" />
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã hệ đào tạo
				</td>
				<td colspan="2">
					<c:out value="${hedaotao.maHeDt}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên hệ đào tạo
				</td>
				<td colspan="2">
					<c:out value="${hedaotao.tenHeDt}" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Chỉnh Sửa" name="btnUpdate" />
				</td>
				<td>
					<input type="button" value="Xóa" name="btnDelete" />
				</td>
				<td>
					<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='HeDaoTao.do';" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>