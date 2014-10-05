<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<span class="icon"><img src="./images/icon/dashboard-icon.png"></span>
			<hgroup>
				<h1>QUẢN LÝ DANH MỤC</h1>
				<h2>Danh sách các danh mục</h2>
			</hgroup>
		</header>
		<div class="content cycle">
		<h1>Thông tin sinh viên</h1>
		<table width="269" height="114" border="0">
		  <tr>
		    <td width="108" bgcolor="#CCCCCC">Mã Sinh Viên</td>
		    <td width="145"><form id="form1" name="form1" method="post" action="">
		      <label>
		        <input type="text" name="textfield" />
		        </label>
		   </td>
		</form>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Tên Sinh Viên</td>
		    <td><input type="text" name="textfield2" /></td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Lớp</td>
		    <td><input type="text" name="textfield3" /></td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Ngành</td>
		    <td><input type="text" name="textfield43" /></td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Chuyên ngành</td>
		    <td><input type="text" name="textfield4" /></td>
		  </tr>
		  <tr>
		    <td bgcolor="#CCCCCC">Khóa</td>
		    <td><input type="text" name="textfield42" /></td>
		  </tr>
		</table>
		<h1>BẢNG ĐIỂM</h1>
		<form id="form2" name="form2" method="post" action="">
		  <label>
		  <select name="select">
		    <option>Học kỳ I</option>
		    <option>Học kỳ II</option>
		    <option>Học kỳ III</option>
		  </select>
		  </label>
		</form>
		<table width="809" border="1" bordercolor="0">
		  <tr>
		    <td width="199" bgcolor="#CCCCCC">Tên môn học</td>
		    <td width="144" bgcolor="#CCCCCC">Điểm chuyên cần</td>
		    <td width="144" bgcolor="#CCCCCC">Điểm giữa kỳ</td>
		    <td width="144" bgcolor="#CCCCCC">Điểm thi</td>
		    <td width="144" bgcolor="#CCCCCC">Tổng kết</td>
		  </tr>
		  <tr>
		    <td>&nbsp;</td>
		    <td><form id="form3" name="form3" method="post" action="">
		      <label>
		        <input type="text" name="textfield5" />
		        </label>
		    </form>    </td>
		    <td><input type="text" name="textfield52" /></td>
		    <td><input type="text" name="textfield53" /></td>
		    <td>&nbsp;</td>
		  </tr>
		</table>
		<p>Tổng kết phẩy của học kỳ này :</p>
		<p>Xếp loại :</p>
		<h1>XẾP LOẠI</h1>
		<table width="481" border="1" bordercolor="#000000" bgcolor="#FFFFFF">
		  <tr bgcolor="#CCCCCC">
		    <td width="155">Tổng kết phẩy cả khóa</td>
		    <td width="120">Điểm đồ án</td>
		    <td width="184">Xếp loại tốt nghiệp</td>
		  </tr>
		  <tr>
		    <td>&nbsp;</td>
		    <td>&nbsp;</td>
		    <td>&nbsp;</td>
		  </tr>
		</table>
		<form id="form4" name="form4" method="post" action="">
		  <label>
		  <input name="Submit" type="submit" id="Submit" value="Tr&#7903; l&#7841;i" />
		  </label>
		</form>
		<p>&nbsp; </p>
		<p>&nbsp;</p>
</div>
	</section>
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