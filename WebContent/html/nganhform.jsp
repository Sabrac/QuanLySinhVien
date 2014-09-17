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

	<form action="NganhProcess.do?submit=true" method="post">
		<input type="hidden" value="${ref}" name="ref" />
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã ngành
				</td>
				<td>
					<input type="text" name="manganh" value="${nganh.maNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên ngành
				</td>
				<td>
					<input type="text" name="tennganh" value="${nganh.tenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Ghi Chú
				</td>
				<td>
					<input type="text" name="ghichu" value="${nganh.ghiChu}" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Submit" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>