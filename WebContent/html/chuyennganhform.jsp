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

	<form action="ChuyenNganhProcess.do?submit=true" method="post">
		<input type="hidden" value="${ref}" name="ref" />
		<input type="hidden" value="${id}" name="id" />
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã chuyên ngành
				</td>
				<td>
					<input type="text" name="machuyennganh" value="${chuyennganh.maChuyenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên chuyên ngành
				</td>
				<td>
					<input type="text" name="tenchuyennganh" value="${chuyennganh.tenChuyenNganh}" />
				</td>
			</tr>
			<tr>
				<td>
					Ngành
				</td>
				<td>
					<select name="nganhid">
						<option value="-1">
							Chọn ngành
						</option>
						<c:forEach items="${lsNganh}" var="nganh">
							<c:choose>
								<c:when test="${nganh.nganhId == chuyennganh.nganhId}">
									<option value="${nganh.nganhId}" SELECTED>
										<c:out value="${nganh.tenNganh}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${nganh.nganhId}">
										<c:out value="${nganh.tenNganh}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
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