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

	<c:if test="${showTable == null}">
	<form action="DanTocForm.do" method="get">
		<table align="center">
			<tr>
				<th>
					ID
				</th>
				<th>
					TÊN DÂN TỘC
				</th>
			</tr>
			<c:forEach items="${lsData}" var="danToc">
				<tr>
					<td align="right">
						<c:out value="${danToc.danTocId}" />
					</td>
					<td align="left">
						<c:out value="${danToc.tenDanToc}" />
					</td>
				</tr>
			</c:forEach>
		</table>
	<div class="btn">
			<table align="center">
				<tr>
					<td>
						<input type="submit" name="btnAdd" value="Thêm" />
					</td>
	</c:if>
	</form>
					<td>
						<input type="button" name="btnBack" value="Trở Về" onclick="window.history.back()" />
					</td>
				</tr>
			</table>
		</div>

</body>
</html>