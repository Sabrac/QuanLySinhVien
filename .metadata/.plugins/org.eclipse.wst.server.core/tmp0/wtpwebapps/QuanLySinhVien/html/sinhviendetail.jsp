<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function onDelete() {
		document.getElementsByName('ref')[0].value = "delete";
		document.getElementById('form').action = "SinhVienProcess.do?submit=true";
		document.getElementById('form').submit();
	}
</script>
</head>
<body>
	<form action="SinhVienProcess.do" method="post" id="form">
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="ref" value="update" />
		<table align="center">
			<tr>
				<td>
					Ảnh sinh viên
				</td>
				<td>
					<img src="${sinhvien.anhSinhVien}">
				</td>
			</tr>
			<tr>
				<td>
					Mã sinh viên
				</td>
				<td>
					<c:out value="${sinhvien.maSinhVien}" />
				</td>
			</tr>
			<tr>
				<td>
					Họ đệm
				</td>
				<td>
					<c:out value="${sinhvien.hoDem}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên
				</td>
				<td>
					<c:out value="${sinhvien.ten}" />
				</td>
			</tr>
			<tr>
				<td>
					Ngày sinh
				</td>
				<td>
					<fmt:formatDate var="ngaysinh" value="${sinhvien.ngaySinh}" pattern="yyyy-MM-dd" />
					<c:out value="${ngaysinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
				</td>
				<td>
					<c:choose>
						<c:when test="${sinhvien.gioiTinh}">
							Nam
						</c:when>
						<c:otherwise>
							Nữ
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					Số chứng minh thư
				</td>
				<td>
					<c:out value="${sinhvien.cmtnd}" />
				</td>
			</tr>
			<tr>
				<td>
					Số điện thoại
				</td>
				<td>
					<c:out value="${sinhvien.soDienThoai}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi sinh
				</td>
				<td>
					<c:out value="${sinhvien.noiSinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Quê quán
				</td>
				<td>
					<c:out value="${sinhvien.queQuan}" />
				</td>
			</tr>
			<tr>
				<td>
					Hộ khẩu thường trú
				</td>
				<td>
					<c:out value="${sinhvien.hoKhauThuongTru}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi ở hiện tại
				</td>
				<td>
					<c:out value="${sinhvien.noiOHienTai}" />
				</td>
			</tr>
			<tr>
				<td>
					Chế độ ưu đãi
				</td>
				<td>
					<c:out value="${sinhvien.cheDoUuDai}" />
				</td>
			</tr>
			<tr>
				<td>
					Dân tộc
				</td>
				<td>
						<c:forEach items="${lsDanToc}" var="danToc">
								<c:if test="${danToc.danTocId == sinhvien.danTocId}">
										<c:out value="${danToc.tenDanToc}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Tôn giáo
				</td>
				<td>
						<c:forEach items="${lsTonGiao}" var="tonGiao">
								<c:if test="${tonGiao.tonGiaoId == sinhvien.tonGiaoId}">
										<c:out value="${tonGiao.tenTonGiao}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Quốc tịch
				</td>
				<td>
						<c:forEach items="${lsQuocTich}" var="quocTich">
								<c:if test="${quocTich.quocTichId == sinhvien.quocTichId}">
										<c:out value="${quocTich.tenQuocTich}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Họ tên bố
				</td>
				<td>
					<c:out value="${sinhvien.hoTenBo}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp bố
				</td>
				<td>
					<c:out value="${sinhvien.ngheNghiepBo}" />
				</td>
			</tr>
			<tr>
				<td>
					Họ tên mẹ
				</td>
				<td>
					<c:out value="${sinhvien.hoTenMe}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp mẹ
				</td>
				<td>
					<c:out value="${sinhvien.ngheNghiepMe}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ đào tạo
				</td>
				<td>
						<c:forEach items="${lsHdt}" var="heDaoTao">
								<c:if test="${heDaoTao.heDtId == sinhvien.heDtId}">
										<c:out value="${heDaoTao.tenHeDt}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Tên lớp học
				</td>
				<td>
						<c:forEach items="${lsLop}" var="lopHoc">
								<c:if test="${lopHoc.lopHocId == sinhvien.lopId}">
										<c:out value="${lopHoc.tenLopHoc}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Tên khóa học
				</td>
				<td>
						<c:forEach items="${lsKhoaHoc}" var="khoaHoc">
								<c:if test="${khoaHoc.khoaHocId == sinhvien.khoaHocId}">
										<c:out value="${khoaHoc.tenKhoaHoc}" />
								</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>
					Ngày nhập học
				</td>
				<td>
					<fmt:formatDate var="ngaynhaphoc" value="${sinhvien.ngayNhapHoc}" pattern="yyyy-MM-dd" />
					<c:out value="${ngaynhaphoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 1
				</td>
				<td>
					<c:out value="${sinhvien.diemDauVao1}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 2
				</td>
				<td>
					<c:out value="${sinhvien.diemDauVao2}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 3
				</td>
				<td>
					<c:out value="${sinhvien.diemDauVao3}" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Chỉnh Sửa" name="btnUpdate" />
				</td>
				<td>
					<input type="button" value="Xóa" name="btnDelete" onclick="onDelete();" />
				</td>
				<td>
					<input type="button" value="Trở về" name="btnBack" onclick="window.location.href='SinhVien.do';" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>