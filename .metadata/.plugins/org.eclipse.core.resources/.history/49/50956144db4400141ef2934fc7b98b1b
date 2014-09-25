<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  document.onkeydown = function(){
     if(window.event && window.event.keyCode == 116){ // Capture and remap F5
         window.event.keyCode = 505;
     }
     if(window.event && window.event.keyCode == 505){ // New action for F5
         return false;  // Must return false or the browser will refresh anyway
    }
}
</script>
</head>
<body>
	<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<c:if test="${showTable == null}">

	<form action="Nganh.do" name="searchform" id="searchform" method="post">
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã ngành
				</td>
				<td>
					<input type="text" name="manganh" value="${manganh}" />
				</td>
				<td colspan="2" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
			</tr>
			<tr>
				<td>
					Tên ngành
				</td>
				<td>
					<input type="text" name="tennganh" value="${tennganh}" />
				</td>
			</tr>
		</table>
	</form>

	<form action="NganhProcess.do" method="post">
		<input type="hidden" value="add" name="ref" />
		<table align="center">
			<tr>
				<th>
					MÃ NGÀNH
				</th>
				<th>
					TÊN NGÀNH
				</th>
			</tr>
			<c:forEach items="${lsData}" var="nganh">
				<tr>
					<td>
						<a href="NganhDetail.do?id=${nganh.nganhId}" ><c:out value="${nganh.maNganh}" /></a>
					</td>
					<td>
						<c:out value="${nganh.tenNganh}" />
					</td>
				</tr>
			</c:forEach>
		</table>

		<div class="paging" align="center">
			<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<a href='/QuanLySinhVien/Nganh.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/Nganh.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/Nganh.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
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