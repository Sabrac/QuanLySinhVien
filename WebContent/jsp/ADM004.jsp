<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/user.js"></script>
<jsp:include page="header.jsp" />
	<script language="javascript">
	function toggle() {
		var table = document.getElementById('tblInput');
	    var tr = table.getElementsByTagName('tr');
		var rowCount = tr.length;
		for (i = 0; i < rowCount; i++) {
			if (i > 7) {
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
<!--
<form method="post" name="addParam">
	<input type="hidden" name="ref" value="${ref}" />
</form>
 -->
<!-- Begin vung input-->
	<form action="" method="post" name="addParam">
	<input type="hidden" value="${ref}" name="ref" />
	<table  class="tbl_input" border="0" width="75%"  cellpadding="0" cellspacing="0" >
		<tr>
			<th align="left">
				<div style="padding-left:100px;">
					情報確認<br>
					入力された情報をＯＫボタンクリックでＤＢへ保存してください
				</div>
				<div style="padding-left:100px;">&nbsp;</div>
			</th>
		</tr>
		<tr>
			<td align="left" >
				<div style="padding-left:100px;">
					<table id="tblInput" border="1" width="70%" class="tbl_input" cellpadding="4" cellspacing="0" >
					<tr>
						<td class="lbl_left">アカウント名:</td>
						<td align="left"><c:out value='${userInfor.loginName}' /></td>
					</tr>
					<tr>
						<td class="lbl_left">グループ:</td>
						<td align="left"><c:out value='${userInfor.groupName}' /></td>
					</tr>
					<tr>
						<td class="lbl_left">氏名:</td>
						<td align="left"><c:out value='${userInfor.fullName}' /></td>
					</tr>
					<tr>
						<td class="lbl_left">カタカナ氏名:</td>
						<td align="left"><c:out value='${userInfor.kanaName}' /></td>
					</tr>
					<tr>
						<fmt:formatDate var="birth" value="${userInfor.birth}" pattern="yyyy/MM/dd" />
						<td class="lbl_left">生年月日:</td>
						<td align="left"><c:out value='${birth}' /></td>
					</tr>
					<tr>
						<td class="lbl_left">メールアドレス:</td>
						<td align="left"><c:out value='${userInfor.email}' /></td>
					</tr>
					<tr>
						<td class="lbl_left">電話番号:</td>
						<td align="left"><c:out value='${userInfor.tel}' /></td>
					</tr>
					<tr>
						<th colspan = "2" align="center"><a href = "javascript:toggle();">日本語能力</a></th>
					</tr>
					<tr style="display: none">
						<td class="lbl_left">資格:</td>
						<c:choose>
							<c:when test="${userInfor.codeLevel ne '-1'}">
								<td align="left"><c:out value='${userInfor.nameLevel}' /></td>
							</c:when>
							<c:otherwise>
								<td align="left">&nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr style="display: none">
						<fmt:formatDate var="startDate" value="${userInfor.startDate}" pattern="yyyy/MM/dd" />
						<td class="lbl_left">資格交付日:</td>
						<c:choose>
							<c:when test="${userInfor.codeLevel ne '-1'}">
								<td align="left"><c:out value='${startDate}' /></td>
							</c:when>
							<c:otherwise>
								<td align="left">&nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr style="display: none">
						<fmt:formatDate var="endDate" value="${userInfor.endDate}" pattern="yyyy/MM/dd" />
						<td class="lbl_left">失効日:</td>
						<c:choose>
							<c:when test="${userInfor.codeLevel ne '-1'}">
								<td align="left"><c:out value='${endDate}' /></td>
							</c:when>
							<c:otherwise>
								<td align="left">&nbsp;</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr style="display: none">
						<td class="lbl_left">点数:</td>
						<c:choose>
							<c:when test="${userInfor.codeLevel ne '-1'}">
								<td align="left"><c:out value='${userInfor.pointString}' /></td>
							</c:when>
							<c:otherwise>
								<td align="left">&nbsp;</td>
							</c:otherwise>
						</c:choose>
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
					<input class="btn" type="submit" onclick="this.disabled=true;test('AddUserConfirm.do');" value="OK" />
				</td>
				<td>
					<input class="btn" type="button" onclick="test('${back}')" value="戻る" />
				</td>
		</tr>
	</table>
	<!-- End vung button -->
</form>
<!-- End vung input -->

<!-- Begin vung footer -->
<jsp:include page="footer.jsp" />
<!-- End vung footer -->
</body>

</html>