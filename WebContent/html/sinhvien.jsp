<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>Retina Dashboard</title>
	<link rel="stylesheet" href="css/style.css" media="all" />
	<script>
		function redirect(dmName) {
			window.location.href = "ListDM.do?name=" + dmName;
		}
	</script>
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
	<!--[if lt IE 9]><link rel="stylesheet" href="css/lt-ie-9.css" media="all" /><![endif]-->
</head>
<body>
<div class="testing">
<header class="main">
	<h1><strong>Retina</strong> Dashboard</h1>
	<input type="text" value="search" />
</header>
<section class="user">
	<div class="profile-img">
		<p><img src="./images/uiface2.png" alt="" height="40" width="40" /> Welcome back <c:out value="${loginId}" /></p>
	</div>
	<div class="buttons">
		<span class="button">Help</span>
		<span class="button blue"><a href="/QuanLySinhVien/Logout.do">Đăng xuất</a></span>
	</div>
</section>
</div>
<jsp:include page="left-menu.jsp"></jsp:include>

<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128200;</span>
			<hgroup>
				<h1>QUẢN LÝ DANH MỤC</h1>
				<h2>Danh sách các danh mục</h2>
			</hgroup>
		</header>
		<div class="content cycle">
<c:forEach items="${lsMessage}" var="message">
		<a style="font: bold; color: red"><c:out value="${message}" /></a><br />
	</c:forEach>
	<br />

	<c:if test="${showTable == null}">

	<form action="ChuyenNganh.do" name="searchform" id="searchform" method="post">
	<h1>Quản Lý Sinh Viên</h1>
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã sinh viên
					<input type="text" name="masv" value="${masv}" />
				</td>

				<td>
					Họ đệm
					<input type="text" name="hodem" value="${hodem}" />
				</td>
					<td>
					Tên
					<input type="text" name="ten" value="${ten}" />
				</td>
				<td>
					Ngày sinh
					<input type="text" name="ngaysinh" value="${ngaysinh}" />
				</td>
				<td>
					Quê quán
					<input type="text" name="quequan" value="${quequan}" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
					<select name="gioitinh">
						<option value="-1">
							Chọn giới tính
						</option>
						<c:choose>
							<c:when test="${gioitinh == 1}">
								<option value="1" SELECTED>
									Nam
								</option>
								<option value="0">
									Nữ
								</option>
							</c:when>
							<c:otherwise>
								<option value="1">
									Nam
								</option>
								<option value="0" SELECTED>
									Nữ
								</option>
							</c:otherwise>
						</c:choose>
					</select>
				</td>
				<td>
					Hệ đào tạo
					<select name="hedaotao">
						<option value="-1">
							Chọn hệ đào tạo
						</option>
						<c:forEach items="${lsHdt}" var="heDaoTao">
							<c:choose>
								<c:when test="${heDaoTao.heDtId == hedaotaoid}">
									<option value="${heDaoTao.heDtId}" SELECTED>
										<c:out value="${heDaoTao.tenHeDt}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${heDaoTao.heDtId}">
										<c:out value="${heDaoTao.tenHeDt}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tên lớp học
					<select name="lophoc">
						<option value="-1">
							Chọn lớp học
						</option>
						<c:forEach items="${lsLop}" var="lopHoc">
							<c:choose>
								<c:when test="${lopHoc.lopHocId == lophocid}">
									<option value="${lopHoc.lopHocId}" SELECTED>
										<c:out value="${lopHoc.tenLopHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${lopHoc.lopHocId}">
										<c:out value="${lopHoc.tenLopHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					Tên khóa học
					<select name="khoahoc">
						<option value="-1">
							Chọn khóa học
						</option>
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
							<c:choose>
								<c:when test="${khoaHoc.khoaHocId == khoahocid}">
									<option value="${khoaHoc.khoaHocId}" SELECTED>
										<c:out value="${khoaHoc.tenKhoaHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${khoaHoc.khoaHocId}">
										<c:out value="${khoaHoc.tenKhoaHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>

				 <td valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
			</tr>

		</table>
	</form>

	<form action="SinhVienForm.do" method="get">
		<table align="center">
			<tr>
				<th>
					MÃ SINH VIÊN
				</th>
				<th>
					HỌ ĐỆM
				</th>
				<th>
					TÊN
				</th>
				<th>
					NGÀY SINH
				</th>
				<th>
					GIỚI TÍNH
				</th>
				<th>
					HỆ ĐÀO TẠO
				</th>
				<th>
					LỚP
				</th>
				<th>
					KHÓA HỌC
				</th>
			</tr>
			<c:forEach items="${lsData}" var="sinhVien">
				<tr>
					<td align="left">
						<c:out value="${sinhVien.maSinhVien}" />
					</td>
					<td align="left">
						<c:out value="${sinhVien.hoDem}" />
					</td>
					<td align="left">
						<c:out value="${sinhVien.ten}" />
					</td>
					<td align="center">
						<fmt:formatDate pattern="yyyy/MM/dd" value="${sinhVien.ngaySinh}" />
					</td>
					<td align="left">
						<c:choose>
							<c:when test="${sinhVien.gioiTinh}">
								Nam
							</c:when>
							<c:otherwise>
								Nữ
							</c:otherwise>
						</c:choose>
					</td>
					<td align="left">
						<c:forEach items="${lsHdt}" var="hdt">
							<c:if test="${sinhVien.heDtId == hdt.heDtId}">
								<c:out value="${hdt.tenHeDt}" />
							</c:if>
						</c:forEach>
					</td>
					<td align="left">
						<c:forEach items="${lsLop}" var="lop">
							<c:if test="${sinhVien.lopId == lop.lopHocId}">
								<c:out value="${lop.tenLopHoc}" />
							</c:if>
						</c:forEach>
					</td>
					<td align="left">
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
							<c:if test="${sinhVien.khoaHocId == khoaHoc.khoaHocId}">
								<c:out value="${khoaHoc.tenKhoaHoc}" />
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
							<a href='/QuanLySinhVien/SinhVien.do?page=<c:out value="${curPage - range}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&laquo;</a>
						</c:if>
						<c:choose>
							<c:when test="${page == curPage}">
								<a><c:out value="${curPage}" /></a>
							</c:when>
							<c:otherwise>
								<a href='/QuanLySinhVien/SinhVien.do?page=<c:out value="${curPage}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'><c:out value="${curPage}" /></a>
							</c:otherwise>
						</c:choose>
						<c:if test="${curPage < totalPage && i == (fn:length(lsPage))}">
							<a href='/QuanLySinhVien/SinhVien.do?page=<c:out value="${curPage + 1}" />&sorttype=${sorttype}&sortcolumn=${sortcolumn}'>&raquo;</a>
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

		</div>
	</section>

	<!--
	<div class="widget-container">
		<section class="widget small">
			<header>
				<span class="icon">&#59168;</span>
				<hgroup>
					<h1>Latest comments</h1>
					<h2>What they're saying</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content no-padding timeline">
				<div class="tl-post comments">
					<span class="icon">&#59168;</span>
					<p>
						<a href="#">John Doe says:</a> Lorem ipsum dolor sit amet, consecteteur adipiscing elit sed diam nonummy.
						<span class="reply"><input type="text" value="Respond to comment..."/></span>
					</p>
				</div>
				<div class="tl-post comments">
					<span class="icon">&#59168;</span>
					<p>
						<a href="#">John Doe says:</a> Lorem ipsum dolor sit amet, consecteteur adipiscing elit sed diam nonummy.
						<span class="reply"><input type="text" value="Respond to comment..."/></span>
					</p>
				</div>
				<span class="show-more"><a	 href="#">More</a></span>
			</div>
		</section>

		<section class="widget 	small">
			<header>
				<span class="icon">&#128319;</span>
				<hgroup>
					<h1>Quick Post</h1>
					<h2>Speed things up</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content">
				<div class="field-wrap">
					<input type="text" value="Title"/>
				</div>
				<div class="field-wrap">
					<textarea id="quick_post" rows="5"></textarea>
				</div>
				<button type="submit" class="green">Post</button> <button type="submit" class="">Preview</button>
			</div>
		</section>
	</div>

	<div class="widget-container">
		<section class="widget small">
			<header>
				<span class="icon">&#128318;</span>
				<hgroup>
					<h1>Website figures</h1>
					<h2>Facts &amp; figures</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content">
				<section class="stats-wrapper">
					<div class="stats">
						<p><span>64</span></p>
						<p>Pages</p>
					</div>
					<div class="stats">
						<p><span>362</span></p>
						<p>Comments</p>
					</div>
				</section>
				<section class="stats-wrapper">
					<div class="stats">
						<p><span>7</span></p>
						<p>Users</p>
					</div>
					<div class="stats">
						<p><span>927</span></p>
						<p>Assets</p>
					</div>
				</section>
			</div>
		</section>

		<section class="widget small">
			<header>
				<span class="icon">&#128363;</span>
				<hgroup>
					<h1>Timeline</h1>
					<h2>Insiders news</h2>
				</hgroup>
				<aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox" /></li>
							<li><label>Option b</label><input type="checkbox" checked="checked" /></li>
							<li><label>Option c</label><input type="checkbox" /></li>
						</ul>
					</span>
				</aside>
			</header>
			<div class="content no-padding timeline">
				<div class="tl-post">
					<span class="icon">&#128206;</span>
					<p><a href="#">John Doe</a> attached an image to a blog post.</p>
				</div>
				<div class="tl-post">
					<span class="icon">&#59172;</span>
					<p><a href="#">John Doe</a> added his location.</p>
				</div>
				<div class="tl-post">
					<span class="icon">&#59170;</span>
					<p><a href="#">John Doe</a> edited his profile.</p>
				</div>
				<div class="tl-post">
					<span class="icon">&#9993;</span>
					<p><a href="#">John Doe</a> has sent you  private message.</p>
				</div>
				<div class="pie graph-area"></div>
			</div>
		</section>
	</div>
	-->
</section>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script src="../js/jquery.wysiwyg.js"></script>
<script src="../js/custom.js"></script>
<script src="../js/cycle.js"></script>
<script src="../js/jquery.checkbox.min.js"></script>
<script src="../js/flot.js"></script>
<script src="../js/flot.resize.js"></script>
<script src="../js/flot-time.js"></script>
<script src="../js/flot-pie.js"></script>
<script src="../js/flot-graphs.js"></script>
<script src="../js/cycle.js"></script>
<script src="../js/jquery.tablesorter.min.js"></script>
<script type="text/javascript">
// Feature slider for graphs
$('.cycle').cycle({
	fx: "scrollHorz",
	timeout: 0,
    slideResize: 0,
    prev:    '.left-btn',
    next:    '.right-btn'
});
</script>
</body>
</html>