<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	<form action="MonHoc.do" name="searchform" id="searchform" method="post">
		<table align="center" class="searchbox">
			<tr>
				<td>
					ID
				</td>
				<td>
					<input type="text" name="monhocid" value="${monhocid}" />
				</td>
				<td colspan="4" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
			</tr>
			<tr>
				<td>
					Tên môn học
				</td>
				<td>
					<input type="text" name="tenmonhoc" value="${tenmonhoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên chuyên ngành
				</td>
				<td>
					<input type="text" name="tenchuyennganh" value="${tenchuyennganh}" />
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
								<c:when test="${chuyenNganh.chuyenNganhId == chuyennganhid}">
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
		</table>
	</form>

	<form action="MonHocForm.do" method="get">
		<table align="center">
			<tr>
				<th>
					ID
				</th>
				<th>
					TÊN MÔN HỌC
				</th>
				<th>
					CHUYÊN NGÀNH
				</th>
			</tr>
			<c:forEach items="${lsData}" var="monHoc">
				<tr>
					<td>
						<c:out value="${monHoc.monHocId}" />
					</td>
					<td>
						<c:out value="${monHoc.tenMonHoc}" />
					</td>
					<td>
						<c:forEach items="${lsChuyenNganh}" var="chuyenNganh">
							<c:if test="${monHoc.chuyenNganhId == chuyenNganh.chuyenNganhId}">
								<c:out value="${chuyenNganh.tenChuyenNganh}" />
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="paging" align="center">
			<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<a href='/QuanLySinhVien/MonHoc.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/MonHoc.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/MonHoc.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
						</c:if>
						<c:set var="i" value="${i + 1}" />
					</c:forEach>
			</c:if>
		</div>

	<div class="btn">
			<table align="center">
				<tr>
					<td>
						<input type="submit" name="btnAdd" value="Thêm" />
					</td>
	</form>
	</c:if>
					<td>
						<input type="button" name="btnBack" value="Trở Về" onclick="window.history.back()" />
					</td>
				</tr>
			</table>
		</div>
</body>
</html>