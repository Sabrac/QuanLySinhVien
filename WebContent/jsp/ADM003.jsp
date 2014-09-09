<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
<html>
<head>
	<script language="javascript">
	function toggle() {
		var table = document.getElementById('tblInput');
	    var tr = table.getElementsByTagName('tr');
		var rowCount = tr.length;
		for (i = 0; i < rowCount; i++) {
			if (i > 9) {
				if (tr[i].style.display == 'none') {
					tr[i].style.display = '';
				} else {
					tr[i].style.display = 'none';
				}
			}
		}
	}
	</script>
</head>
<body>
<!-- Begin vung input-->
	<form action="/manage_user_vuhongha/AddUser.do?submit=true" method="post" name="inputform">
	<input type="hidden" value="${ref}" name="ref" />
	<table  class="tbl_input" border="0" width="75%"  cellpadding="0" cellspacing="0" >
		<tr>
			<th align="left">
				<div style="padding-left:100px;">
					会員情報編集
				</div>
			</th>
		</tr>

		<!-- BEGIN ERROR MESSAGE -->

		<c:if test="${lsError != null}">
			<c:forEach items="${lsError}" var="mess">
				<tr>
					<td class="errMsg">
						<div style="padding-left:120px">
							<c:out value="${mess}" />
						</div>
					</td>
				</tr>
			</c:forEach>
		</c:if>

		<!-- END ERROR MESSAGE -->

		<tr>
			<td align="left" >
				<div style="padding-left:100px;">
					<table border="0" width="100%" class="tbl_input" cellpadding="4" cellspacing="0" id="tblInput">
					<tr>
						<td class="lbl_left"><font color = "red">*</font> アカウント名:</td>
						<td align="left">
							<input type="hidden" values="<c:out value='${userInfor.ID}' />" />
							<input maxlength="15" class="txBox" type="text" name="id" value="<c:out value='${userInfor.loginName}' />"
							size="15" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<td class="lbl_left"><font color = "red">*</font> グループ:</td>
						<td align="left">
							<select name="group_id">
								<option value="-1">選択してください</option>
								<c:forEach items="${lsGroup}" var="group">
									<c:choose>
										<c:when test="${group.id == userInfor.groupId}">
											<option value="${group.id}" SELECTED><c:out value="${group.name}" /></option>
										</c:when>
										<c:otherwise>
											<option value="${group.id}"><c:out value="${group.name}" /></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<span>&nbsp;&nbsp;&nbsp;</span>
						</td>
					</tr>
					<tr>
						<td class="lbl_left"><font color = "red">*</font> 氏名:</td>
						<td align="left">
						<input class="txBox" type="text" name="name" value="<c:out value='${userInfor.fullName}' />"
							size="30" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<td class="lbl_left">カタカナ氏名:</td>
						<td align="left">
						<input class="txBox" type="text" name="kanaName" value="<c:out value='${userInfor.kanaName}' />"
							size="30" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<td class="lbl_left"><font color = "red">*</font> 生年月日:</td>
						<td align="left">

						<fmt:formatDate var="curYear" value="${userInfor.birth}" pattern="yyyy" />

						<fmt:formatDate var="curMonth" value="${userInfor.birth}" pattern="MM" />
						<c:if test="${curMonth < 10}">
							<fmt:formatDate var="curMonth" value="${userInfor.birth}" pattern="M" />
						</c:if>
						<fmt:formatDate var="curDay" value="${userInfor.birth}" pattern="dd" />
						<c:if test="${curDay < 10}">
							<fmt:formatDate var="curDay" value="${userInfor.birth}" pattern="d" />
						</c:if>

						<select name="birthYear">
							<c:forEach items="${lsBirthYear}" var="year">
								<c:out value="${year}" />
								<c:choose>
									<c:when test="${year == curYear}">
										<option value="${year}" SELECTED><c:out value="${year}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${year}"><c:out value="${year}"/></option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>年
						<select name="birthMonth">
							<c:forEach items="${lsMonth}" var="month">
								<c:choose>
									<c:when test="${month == curMonth && !edited}">
										<option value="${month}" SELECTED><c:out value="${month}"/></option>
									</c:when>
									<c:when test="${month == (curMonth - 1) && edited}">
										<option value="${month}" SELECTED><c:out value="${month}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${month}"><c:out value="${month}"/></option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>月
						<select name="birthDate">
							<c:forEach items="${lsDay}" var="day">
								<c:choose>
									<c:when test="${day == curDay}">
										<option value="${day}" SELECTED><c:out value="${day}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${day}"><c:out value="${day}"/></option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>日
						</td>
					</tr>
					<tr>
						<td class="lbl_left"><font color = "red">*</font> メールアドレス:</td>
						<td align="left">
							<input class="txBox" type="text" name="email" value="<c:out value='${userInfor.email}' />"
							size="30" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<td class="lbl_left"><font color = "red">*</font>電話番号:</td>
						<td align="left">
						<input maxlength="14" class="txBox" type="text" name="tel" value="<c:out value='${userInfor.tel}' />"
							size="30" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<td class="lbl_left"><font color = "red">*</font> パスワード:</td>
						<td align="left">
							<input maxlength="15" class="txBox" type="password" name="password" value="${userInfor.pass}"
							size="30" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<td class="lbl_left">パスワード（確認）:</td>
						<td align="left">
							<input maxlength="15" class="txBox" type="password" name="repassword" value="${userInfor.rePass}"
							size="30" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
					<tr>
						<th align="left" colspan = "2" >
								<a href = "javascript:toggle();">日本語能力</a>
						</th>
					</tr>
					<tr style="display: none">
						<td class="lbl_left">資格:</td>
						<td align="left">
							<select name="kyu_id">
								<option value="-1">選択してください</option>
								<c:forEach items="${lsJapan}" var="japan">
									<c:choose>
										<c:when test="${japan.code == userInfor.codeLevel}">
											<option value="${japan.code}" SELECTED><c:out value="${japan.name}" /></option>
										</c:when>
										<c:otherwise>
											<option value="${japan.code}"><c:out value="${japan.name}" /></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr style="display: none">
						<td class="lbl_left">資格交付日: </td>
						<td align="left">
							<select name="startYear">
							<fmt:formatDate var="curYear" value="${userInfor.startDate}" pattern="yyyy" />
							<fmt:formatDate var="curMonth" value="${userInfor.startDate}" pattern="MM" />
							<c:if test="${curMonth < 10}">
								<fmt:formatDate var="curMonth" value="${userInfor.startDate}" pattern="M" />
							</c:if>
							<fmt:formatDate var="curDay" value="${userInfor.startDate}" pattern="dd" />
							<c:if test="${curDay < 10}">
								<fmt:formatDate var="curDay" value="${userInfor.startDate}" pattern="d" />
							</c:if>
								<c:forEach items="${lsBirthYear}" var="year">
									<c:choose>
										<c:when test="${year == curYear}">
											<option value="${year}" SELECTED><c:out value="${year}"/></option>
										</c:when>
										<c:otherwise>
											<option value="${year}"><c:out value="${year}"/></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>年
							<select name="startMonth">
								<c:forEach items="${lsMonth}" var="month">
									<c:choose>
									<c:when test="${month == curMonth && !edited}">
										<option value="${month}" SELECTED><c:out value="${month}"/></option>
									</c:when>
									<c:when test="${month == (curMonth - 1) && edited}">
										<option value="${month}" SELECTED><c:out value="${month}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${month}"><c:out value="${month}"/></option>
									</c:otherwise>
								</c:choose>
								</c:forEach>
							</select>月
							<select name="startDate">
								<c:forEach items="${lsDay}" var="day">
									<c:choose>
										<c:when test="${day == curDay}">
											<option value="${day}" SELECTED><c:out value="${day}"/></option>
										</c:when>
										<c:otherwise>
											<option value="${day}"><c:out value="${day}"/></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>日
						</td>
					</tr>
					<tr style="display: none">
						<td class="lbl_left">失効日: </td>
						<td align="left">
							<fmt:formatDate var="curYear" value="${userInfor.endDate}" pattern="yyyy" />
							<fmt:formatDate var="curMonth" value="${userInfor.endDate}" pattern="MM" />
							<c:if test="${curMonth < 10}">
								<fmt:formatDate var="curMonth" value="${userInfor.endDate}" pattern="M" />
							</c:if>
							<fmt:formatDate var="curDay" value="${userInfor.endDate}" pattern="dd" />
							<c:if test="${curDay < 10}">
								<fmt:formatDate var="curDay" value="${userInfor.endDate}" pattern="d" />
							</c:if>
							<select name="endYear">
								<c:forEach items="${lsEndYear}" var="year">
									<c:choose>
										<c:when test="${year == curYear}">
											<option value="${year}" SELECTED><c:out value="${year}"/></option>
										</c:when>
										<c:otherwise>
											<option value="${year}"><c:out value="${year}"/></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>年
							<select name="endMonth">
								<c:forEach items="${lsMonth}" var="month">
									<c:choose>
									<c:when test="${month == curMonth && !edited}">
										<option value="${month}" SELECTED><c:out value="${month}"/></option>
									</c:when>
									<c:when test="${month == (curMonth - 1) && edited}">
										<option value="${month}" SELECTED><c:out value="${month}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${month}"><c:out value="${month}"/></option>
									</c:otherwise>
								</c:choose>
								</c:forEach>
							</select>月
							<select name="endDate">
								<c:forEach items="${lsDay}" var="day">
									<c:choose>
										<c:when test="${day == curDay}">
											<option value="${day}" SELECTED><c:out value="${day}"/></option>
										</c:when>
										<c:otherwise>
											<option value="${day}"><c:out value="${day}"/></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>日
						</td>
					</tr>
					<tr style="display: none">
						<td class="lbl_left">点数: </td>
						<td align="left">
						<input class="txBox" type="text" name="total" value="<c:out value='${userInfor.pointString}' />"
							size="5" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
					</tr>
				</table>
				</div>
			</td>
		</tr>
	</table>
	<div style="padding-left:100px;">&nbsp;</div>
		<!-- Begin vung button -->
	<div style="padding-left:45px;">
	<table border="0" cellpadding="4" cellspacing="0" width="300px">
		<tr>
			<th width="200px" align="center">&nbsp;</th>
				<td>
					<input class="btn" type="submit" value="確認" />
				</td>
				<td>
					<input class="btn" onclick="window.location.href='${back}';" type="button" value="戻る" />
				</td>
		</tr>
	</table>
	<!-- End vung button -->
</form>
<!-- End vung input -->

</body>
<jsp:include page="footer.jsp" />
</html>