<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<form action="ChuyenNganh.do" name="searchform" id="searchform" method="post">
		<table align="center" class="searchbox">
			<tr>
				<td>
					Mã sinh viên
				</td>
				<td>
					<input type="text" name="masv" value="${masv}" />
				</td>
				<td colspan="4" valign="middle" align="center">
					<input type="submit" name="btnSubmit" id="btnSubmit" value="Tìm kiếm" />
				</td>
			</tr>
			<tr>
				<td>
					Họ đệm
				</td>
				<td>
					<input type="text" name="hodem" value="${hodem}" />
				</td>
			</tr>
			<tr>
				<td>
					Tên
				</td>
				<td>
					<input type="text" name="ten" value="${ten}" />
				</td>
			</tr>
			<tr>
				<td>
					Ngày sinh
				</td>
				<td>
					<input type="text" name="ngaysinh" value="${ngaysinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Giới tính
				</td>
				<td>
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
			</tr>
			<tr>
				<td>
					Số chứng minh thư
				</td>
				<td>
					<input type="text" name="socmt" value="${socmt}" />
				</td>
			</tr>
			<tr>
				<td>
					Số điện thoại
				</td>
				<td>
					<input type="text" name="sodienthoai" value="${sodienthoai}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi sinh
				</td>
				<td>
					<input type="text" name="noisinh" value="${noisinh}" />
				</td>
			</tr>
			<tr>
				<td>
					Quê quán
				</td>
				<td>
					<input type="text" name="quequan" value="${quequan}" />
				</td>
			</tr>
			<tr>
				<td>
					Hộ khẩu thường trú
				</td>
				<td>
					<input type="text" name="hokhau" value="${hokhau}" />
				</td>
			</tr>
			<tr>
				<td>
					Nơi ở hiện tại
				</td>
				<td>
					<input type="text" name="noiohientai" value="${noiohientai}" />
				</td>
			</tr>
			<tr>
				<td>
					Chế độ ưu đãi
				</td>
				<td>
					<input type="text" name="chedo" value="${chedo}" />
				</td>
			</tr>
			<tr>
				<td>
					Dân tộc
				</td>
				<td>
					<select name="dantoc">
						<option value="-1">
							Chọn dân tộc
						</option>
						<c:forEach items="${lsDanToc}" var="danToc">
							<c:choose>
								<c:when test="${danToc.danTocId == dantocid}">
									<option value="${danToc.danTocId}" SELECTED>
										<c:out value="${danToc.tenDanToc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${danToc.danTocId}">
										<c:out value="${danToc.tenDanToc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Tôn giáo
				</td>
				<td>
					<select name="tongiao">
						<option value="-1">
							Chọn tôn giáo
						</option>
						<c:forEach items="${lsTonGiao}" var="tonGiao">
							<c:choose>
								<c:when test="${tonGiao.tonGiaoId == tongiaoid}">
									<option value="${tonGiao.tonGiaoId}" SELECTED>
										<c:out value="${tonGiao.tenTonGiao}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${tonGiao.tonGiaoId}">
										<c:out value="${tonGiao.tenTonGiao}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Quốc tịch
				</td>
				<td>
					<select name="quoctich">
						<option value="-1">
							Chọn quốc tịch
						</option>
						<c:forEach items="${lsQuocTich}" var="quocTich">
							<c:choose>
								<c:when test="${quocTich.quocTichId == quoctichid}">
									<option value="${quocTich.quocTichId}" SELECTED>
										<c:out value="${quocTich.tenQuocTich}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${quocTich.quocTichId}">
										<c:out value="${quocTich.tenQuocTich}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Họ tên bố
				</td>
				<td>
					<input type="text" name="hotenbo" value="${hotenbo}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp bố
				</td>
				<td>
					<input type="text" name="nghenghiepbo" value="${nghenghiepbo}" />
				</td>
			</tr>
			<tr>
				<td>
					Họ tên mẹ
				</td>
				<td>
					<input type="text" name="hotenme" value="${hotenme}" />
				</td>
			</tr>
			<tr>
				<td>
					Nghề nghiệp mẹ
				</td>
				<td>
					<input type="text" name="nghenghiepme" value="${nghenghiepme}" />
				</td>
			</tr>
			<tr>
				<td>
					Hệ đào tạo
				</td>
				<td>
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
			</tr>
			<tr>
				<td>
					Tên lớp học
				</td>
				<td>
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
			</tr>
			<tr>
				<td>
					Tên khóa học
				</td>
				<td>
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
			<tr>
				<td>
					Ngày nhập học
				</td>
				<td>
					<input type="text" name="ngaynhaphoc" value="${ngaynhaphoc}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 1
				</td>
				<td>
					<input type="text" name="diemdauvao1" value="${diemdauvao1}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 2
				</td>
				<td>
					<input type="text" name="diemdauvao2" value="${diemdauvao2}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm đầu vào 3
				</td>
				<td>
					<input type="text" name="diemdauvao3" value="${diemdauvao3}" />
				</td>
			</tr>
			<tr>
				<td>
					Môn học
				</td>
				<td>
					<select name="monhoc">
						<option value="-1">
							Chọn môn học
						</option>
						<c:forEach items="${lsMonHoc}" var="monHoc">
							<c:choose>
								<c:when test="${monHoc.monHocId == monhocid}">
									<option value="${monHoc.monHocId}" SELECTED>
										<c:out value="${monHoc.tenMonHoc}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${monHoc.monHocId}">
										<c:out value="${monHoc.tenMonHoc}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Lần thi
				</td>
				<td>
					<input type="text" name="lanthi" value="${lanthi}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm thi
				</td>
				<td>
					<input type="text" name="diemthi" value="${diemthi}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm chuyên cần
				</td>
				<td>
					<input type="text" name="diemchuyencan" value="${diemchuyencan}" />
				</td>
			</tr>
			<tr>
				<td>
					Điểm giữa kỳ
				</td>
				<td>
					<input type="text" name="diemgiuaky" value="${diemgiuaky}" />
				</td>
			</tr>
			<tr>
				<td>
					Học kỳ
				</td>
				<td>
					<select name="hocky">
						<option value="-1">
							Chọn học kỳ
						</option>
						<c:forEach items="${lsHocKy}" var="hocKy">
							<c:choose>
								<c:when test="${hocKy.hocKyId == hockyid}">
									<option value="${hocKy.hocKyId}" SELECTED>
										<c:out value="${hocKy.tenHocKy}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="${hocKy.hocKyId}">
										<c:out value="${hocKy.tenHocKy}" />
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
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
</body>
</html>