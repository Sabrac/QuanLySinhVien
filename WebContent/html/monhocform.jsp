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

	<form action="MonHocProcess.do?submit=true" method="post">
		<input type="hidden" name="ref" value="${ref}" />
		<table align="center">
			<tr>
				<td>
					Tên môn học
				</td>
				<td>
					<input type="text" name="tenmonhoc" value="${monhoc.tenMonHoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Số trình
				</td>
				<td>
					<input type="text" name="sotrinh" value="${monhoc.soTrinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ số chuyên cần
				</td>
				<td>
					<c:choose>
						<c:when test="${monhoc.heSoChuyenCan > 0}">
							<input type="text" name="hesochuyencan" value="${monhoc.heSoChuyenCan}" />
						</c:when>
						<c:otherwise>
							<input type="text" name="hesochuyencan" value="" />
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
							<input type="text" name="hesogiuaky" value="${monhoc.heSoGiuaKy}" />
						</c:when>
						<c:otherwise>
							<input type="text" name="hesogiuaky" value="" />
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
							<input type="text" name="hesohocky" value="${monhoc.heSoHocKy}" />
						</c:when>
						<c:otherwise>
							<input type="text" name="hesohocky" value="" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Chuyên ngành
				</td>
				<td>
					<select name="chuyennganhid">
						<option value="-1">
							Chọn chuyên ngành
						</option>
						<c:forEach items="${lsChuyenNganh}" var="chuyenNganh">
							<c:choose>
								<c:when test="${chuyenNganh.chuyenNganhId == monhoc.chuyenNganhId}">
									<option value="${chuyennganh.chuyenNganhId}" SELECTED>
										<c:out value="${chuyenNganh.tenChuyenNganh}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${chuyenNganh.chuyenNganhId}">
										<c:out value="${chuyenNganh.tenChuyenNganh}" />
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