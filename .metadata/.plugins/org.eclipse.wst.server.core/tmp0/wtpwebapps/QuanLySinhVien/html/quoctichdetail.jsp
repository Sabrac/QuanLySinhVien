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
		document.getElementById('form').action = "QuocTichProcess.do?submit=true";
		document.getElementById('form').submit();
	}
</script>
</head>
<body>
	<form action="QuocTichProcess.do" method="post" id="form">
		<input type="hidden" name="ref" value="update" />
		<input type="hidden" name="id" value="${id}" />
		<table align="center">
			<tr>
				<td>
					ID
				</td>
				<td>
					<c:out value="${quoctich.quocTichId}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên quốc tịch
				</td>
				<td>
					<c:out value="${quoctich.tenQuocTich}" />
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
					<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='QuocTich.do';" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>