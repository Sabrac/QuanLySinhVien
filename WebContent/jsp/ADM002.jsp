<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.luvina.manageuser.entities.*" %>
<%@page import="net.luvina.manageuser.utils.*" %>
<%@page import ="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />

<html>
<head>
<script type="text/javascript" src="js/user.js"></script>
</head>
<body>

<!-- Begin vung dieu kien tim kiem -->
<form method="post" name="addParam">
	<input type="hidden" value="ADM002" name="ref" />
</form>
<form action="ListUser.do" method="post" name="mainform">
	<table  class="tbl_input" border="0" width="90%"  cellpadding="0" cellspacing="0" >
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				会員名称で会員を検索します。検索条件無しの場合は全て表示されます。
			</td>
		</tr>
		<tr>
			<td width="100%">
				<table class="tbl_input" cellpadding="4" cellspacing="0" >
					<tr>
						<td class="lbl_left">氏名:</td>
						<td align="left">
						<!-- Start fix bug ID 126 - HaVH 2014/06/17 -->
						<input class="txBox" type="text" name="full_name" value="<c:out value='${full_name}' />"
							size="20" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						<!-- End fix bug ID 126 - HaVH 2014/06/17 -->
						</td>
						<td></td>
					</tr>
					<tr>
						<td class="lbl_left">グループ:</td>
						<td align="left" width="80px">
							<select name="group_id">
								<option value="0" SELECTED>全て</option>
								<c:if test="${lsGroup != null}">
									<c:set var="listGroup" value="${lsGroup}" />
									<c:set var="groupSearch" value="${group_id}" />
									<c:forEach items="${listGroup}" var="group">
										<c:choose>
											<c:when test="${groupSearch == group.id}">
												<option value="${group.id}" SELECTED ><c:out value="${group.name}" /></option>
											</c:when>
											<c:otherwise>
												<option value="${group.id}"><c:out value="${group.name}" /></option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<td align="left">
							<input class="btn" type="submit" value="検索" />
							<input class="btn" type="button" onclick="test('AddUser.do')" value="新規追加" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- End vung dieu kien tim kiem -->
</form>
	<!-- Begin vung hien thi danh sach user -->
<form action="ListUser.do" method="get" name="inputform">
	<!-- Begin Tag hidden -->
	<input type="hidden" name="page" value="1" />
	<input type="hidden" name="full_name" value="<c:out value='${full_name}' />" />
	<input type="hidden" name="group_id" value='' />
	<!-- End Tag hidden -->
	<table class="tbl_list" border="1" cellpadding="4" cellspacing="0" width="80%">
	<c:choose>
		<c:when test="${not empty message}">
			<tr>
				<td class="errMsg"><c:out value="${message}" /></td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr class="tr2">
				<th align="center" width="40px">
					ID
				</th>
				<th align="left">
					氏名
					<c:choose>
						<c:when test="${sortByFullName == 'DESC'}">
							<a href="/manage_user_vuhongha/ListUser.do?page=${page}&sortType=full_name&sortByFullName=ASC">△▼</a>
						</c:when>
						<c:otherwise>
							<a href="/manage_user_vuhongha/ListUser.do?page=${page}&sortType=full_name&sortByFullName=DESC">▲▽</a>
						</c:otherwise>
					</c:choose>
				</th>
				<th align="center">
					生年月日
				</th>
				<th align="left">
					グループ
				</th>
				<th align="left">
					メールアドレス
				</th>
				<th align="left" width="70px">
					電話番号
				</th>
				<th align="left">
					日本語能力
					<c:choose>
						<c:when test="${sortByCodeLevel == 'ASC'}">
							<a href="/manage_user_vuhongha/ListUser.do?page=${page}&sortType=code_level&sortByCodeLevel=DESC">▲▽</a>
						</c:when>
						<c:otherwise>
							<a href="/manage_user_vuhongha/ListUser.do?page=${page}&sortType=code_level&sortByCodeLevel=ASC">△▼</a>
						</c:otherwise>
					</c:choose>
				</th>
				<th align="left">
					失効日
					<c:choose>
						<c:when test="${sortByEndDate == 'ASC'}">
							<a href="/manage_user_vuhongha/ListUser.do?page=${page}&sortType=end_date&sortByEndDate=DESC">▲▽</a>
						</c:when>
						<c:otherwise>
							<a href="/manage_user_vuhongha/ListUser.do?page=${page}&sortType=end_date&sortByEndDate=ASC">△▼</a>
						</c:otherwise>
					</c:choose>
				</th>
				<th align="left">
					点数
				</th>
			</tr>

			<c:if test="${listUser != null}">
				<c:set var="lsUser" value="${listUser}" />
				<c:forEach items="${lsUser}" var="user">
					<tr>
						<td align="right">
							<a href='/manage_user_vuhongha/Detail.do?userId=<c:out value="${user.ID}" />'>${user.ID}</a>
						</td>
						<td>
							<c:out value="${user.fullName}" />
						</td>
						<td align="center">
							<fmt:formatDate pattern="yyyy/MM/dd" value="${user.birth}" />
						</td>
						<td>
							<c:out value="${user.groupName}" />
						</td>
						<td>
							<c:out value="${user.email}" />
						</td>
						<td>
							<c:out value="${user.tel}" />
						</td>
						<td>
							<c:out value="${user.nameLevel}" />
						</td>
						<td align="center">
							<fmt:formatDate pattern="yyyy/MM/dd" value="${user.endDate}" />
						</td>
						<td align="right">
							<c:out value="${user.point}" />
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</c:otherwise>
	</c:choose>
	</table>
</form>
	<!-- End vung hien thi danh sach user -->

	<!-- Begin vung paging -->
	<table>
		<tr>
			<td class = "lbl_paging">
				<!-- Điều kiện hiển thị phân trang -->
				<c:if test="${totalPage > 1}">
					<c:set var="i" value="1" />
					<c:forEach items="${lsPage}" var="curPage">
						<c:if test="${curPage > 1 && i == 1}">
							<c:choose>
								<c:when test="${sortType == 'full_name'}">
									<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage - range}" />&sortType=${sortType}&sortByFullName=${sortByFullName}'>&laquo;</a>
								</c:when>
								<c:when test="${sortType == 'code_level'}">
									<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage - range}" />&sortType=${sortType}&sortByCodeLevel=${sortByCodeLevel}'>&laquo;</a>
								</c:when>
								<c:otherwise>
									<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage - range}" />&sortType=${sortType}&sortByEndDate=${sortByEndDate}'>&laquo;</a>
								</c:otherwise>
							</c:choose>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${sortType == 'full_name'}">
										<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage}" />&sortType=${sortType}&sortByFullName=${sortByFullName}'><c:out value="${curPage}" /></a>
									</c:when>
									<c:when test="${sortType == 'code_level'}">
										<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage}" />&sortType=${sortType}&sortByCodeLevel=${sortByCodeLevel}'><c:out value="${curPage}" /></a>
									</c:when>
									<c:otherwise>
										<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage}" />&sortType=${sortType}&sortByEndDate=${sortByEndDate}'><c:out value="${curPage}" /></a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<c:choose>
								<c:when test="${sortType == 'full_name'}">
									<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage + 1}" />&sortType=${sortType}&sortByFullName=${sortByFullName}'>&raquo;</a>
								</c:when>
								<c:when test="${sortType == 'code_level'}">
									<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage + 1}" />&sortType=${sortType}&sortByCodeLevel=${sortByCodeLevel}'>&raquo;</a>
								</c:when>
								<c:otherwise>
									<a href='/manage_user_vuhongha/ListUser.do?page=<c:out value="${curPage + 1}" />&sortType=${sortType}&sortByEndDate=${sortByEndDate}'>&raquo;</a>
								</c:otherwise>
							</c:choose>
						</c:if>
						<c:set var="i" value="${i + 1}" />
					</c:forEach>
				</c:if>
			</td>
		</tr>
	</table>
	<!-- End vung paging -->

<jsp:include page="footer.jsp" />
</body>
</html>