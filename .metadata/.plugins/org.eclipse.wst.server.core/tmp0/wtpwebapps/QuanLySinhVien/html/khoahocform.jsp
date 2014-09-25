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
	<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<form action="KhoaHocProcess.do?submit=true" method="post">
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" value="${ref}" name="ref" />
		<table align="center">
			<tr>
				<td>
					Tên khóa học
				</td>
				<td>
					<input type="text" name="tenkhoahoc" value="${khoahoc.tenKhoaHoc}" />
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Submit" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>