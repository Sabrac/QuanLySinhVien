<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="managestudent.entities.*" %>
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
		<table>
			<tr>
				<th>
					MÃ CHUYÊN NGÀNH
				</th>
				<th>
					TÊN CHUYÊN NGÀNH
				</th>
				<th>
					TÊN NGÀNH
				</th>
			</tr>


			<c:forEach items="${lsData}" var="chuyenNganh">
				<tr>
					<td align="left">
						<c:out value="${chuyenNganh.maChuyenNganh}" />
					</td align="left">
					<td>
						<c:out value="${chuyenNganh.tenChuyenNganh}" />
					</td>
					<td align="left">
						<c:forEach items="${lsNganh}" var="nganh">
							<c:if test="${chuyenNganh.nganhId == nganh.nganhId}">
								<c:out value="${nganh.tenNganh}" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>

</body>
</html>