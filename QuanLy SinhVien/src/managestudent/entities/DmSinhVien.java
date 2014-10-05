/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVien.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

import java.util.Date;

/**
 *
 * @author HaVH
 *
 */
public class DmSinhVien {
	private int sinhVienId;
	private String maSinhVien;
	private String hoDem;
	private String ten;
	private Date ngaySinh;
	private int gioiTinh; //1: Nam / 0: Nu / -1: Khong chon
	private String cmtnd;
	private String soDienThoai;
	private String noiSinh;
	private String queQuan;
	private String hoKhauThuongTru;
	private String noiOHienTai;
	private String cheDoUuDai;
	private int danTocId;
	private int tonGiaoId;
	private int quocTichId;
	private String hoTenBo;
	private String ngheNghiepBo;
	private String hoTenMe;
	private String ngheNghiepMe;
	private int heDtId;
	private int lopId;
	private int khoaHocId;
	private Date ngayNhapHoc;
	private float diemDauVao1;
	private float diemDauVao2;
	private float diemDauVao3;
	private String anhSinhVien;
	private String tenHeDaoTao;
	private String tenLopHoc;
	private String tenKhoaHoc;
	private String maHeDaoTao;

	/**
	 * Constructor thông tin tổng quát của sinh viên
	 *
	 * @param sinhVienId int id sinh viên
	 * @param maSinhVien String mã sinh viên
	 * @param hoDem String họ đệm
	 * @param ten String tên
	 * @param ngaySinh Date ngày sinh
	 * @param gioiTinh boolean giới tính : true - nam, false: nữ
	 * @param heDtId int id hệ đào tạo
	 * @param lopId int id lớp học
	 * @param khoaHocId int id khóa học
	 */
	public DmSinhVien(int sinhVienId, String maSinhVien, String hoDem, String ten, Date ngaySinh, int gioiTinh, int heDtId, int lopId, int khoaHocId) {
		super();
		this.sinhVienId = sinhVienId;
		this.maSinhVien = maSinhVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.heDtId = heDtId;
		this.lopId = lopId;
		this.khoaHocId = khoaHocId;
	}

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public DmSinhVien() {
		sinhVienId = -1;
		maSinhVien = "";
		hoDem = "";
		ten = "";
		ngaySinh = new Date();
		gioiTinh = -1;
		cmtnd = "";
		soDienThoai = "";
		noiSinh = "";
		queQuan = "";
		hoKhauThuongTru = "";
		noiOHienTai = "";
		cheDoUuDai = "";
		danTocId = -1;
		tonGiaoId = -1;
		quocTichId = -1;
		hoTenBo = "";
		ngheNghiepBo = "";
		hoTenMe = "";
		ngheNghiepMe = "";
		heDtId = -1;
		lopId = -1;
		khoaHocId = -1;
		ngayNhapHoc = new Date();
		diemDauVao1 = -1;
		diemDauVao2 = -1;
		diemDauVao3 = -1;
		anhSinhVien = "";
		tenHeDaoTao = "";
		tenKhoaHoc = "";
		tenLopHoc = "";
		maHeDaoTao = "";
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param sinhVienId int sinh viên id
	 * @param maSinhVien String mã sinh viên
	 * @param hoDem String họ đệm
	 * @param ten String tên
	 * @param ngaySinh Date ngày sinh
	 * @param gioiTinh boolean giới tính (true:nam / false:nữ)
	 * @param cmtnd String chứng minh thư
	 * @param soDienThoai String số điện thoại
	 * @param noiSinh String nơi sinh
	 * @param queQuan String quê quán
	 * @param hoKhauThuongTru String hộ khẩu thường trú
	 * @param noiOHienTai String nơi ở hiện tại
	 * @param cheDoUuDai String chế độ ưu đãi
	 * @param danTocId int dân tộc id
	 * @param tonGiaoId int tôn giáo id
	 * @param quocTichId int quốc tịch id
	 * @param hoTenBo String họ tên bố
	 * @param ngheNghiepBo String nghề nghiệp bố
	 * @param hoTenMe String họ tên mẹ
	 * @param ngheNghiepMe String nghề nghiệp mẹ
	 * @param heDtId int hệ đào tạo id
	 * @param lopId int lớp id
	 * @param khoaHocId int khóa học id
	 * @param ngayNhapHoc Date ngày nhập học
	 * @param diemDauVao1 float điểm đầu vào môn 1
	 * @param diemDauVao2 float điểm đầu vào môn 2
	 * @param diemDauVao3 float điểm đầu vào môn 3
	 * @param anhSinhVien String đường dẫn ảnh sinh viên
	 */
	public DmSinhVien(int sinhVienId, String maSinhVien, String hoDem, String ten, Date ngaySinh, int gioiTinh, String cmtnd, String soDienThoai,
			String noiSinh, String queQuan, String hoKhauThuongTru, String noiOHienTai, String cheDoUuDai, int danTocId, int tonGiaoId, int quocTichId,
			String hoTenBo, String ngheNghiepBo, String hoTenMe, String ngheNghiepMe, int heDtId, int lopId, int khoaHocId, Date ngayNhapHoc,
			float diemDauVao1, float diemDauVao2, float diemDauVao3, String anhSinhVien) {
		this.sinhVienId = sinhVienId;
		this.maSinhVien = maSinhVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cmtnd = cmtnd;
		this.soDienThoai = soDienThoai;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.hoKhauThuongTru = hoKhauThuongTru;
		this.noiOHienTai = noiOHienTai;
		this.cheDoUuDai = cheDoUuDai;
		this.danTocId = danTocId;
		this.tonGiaoId = tonGiaoId;
		this.quocTichId = quocTichId;
		this.hoTenBo = hoTenBo;
		this.ngheNghiepBo = ngheNghiepBo;
		this.hoTenMe = hoTenMe;
		this.ngheNghiepMe = ngheNghiepMe;
		this.heDtId = heDtId;
		this.lopId = lopId;
		this.khoaHocId = khoaHocId;
		this.ngayNhapHoc = ngayNhapHoc;
		this.diemDauVao1 = diemDauVao1;
		this.diemDauVao2 = diemDauVao2;
		this.diemDauVao3 = diemDauVao3;
		this.anhSinhVien = anhSinhVien;
		tenHeDaoTao = "";
		tenKhoaHoc = "";
		tenLopHoc = "";
		maHeDaoTao = "";
	}

	/**
	 * @return the anhSinhVien
	 */
	public String getAnhSinhVien() {
		return anhSinhVien;
	}
	/**
	 * @param anhSinhVien the anhSinhVien to set
	 */
	public void setAnhSinhVien(String anhSinhVien) {
		this.anhSinhVien = anhSinhVien;
	}
	/**
	 * @return the sinhVienId
	 */
	public int getSinhVienId() {
		return sinhVienId;
	}
	/**
	 * @param sinhVienId the sinhVienId to set
	 */
	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
	}
	/**
	 * @return the maSinhVien
	 */
	public String getMaSinhVien() {
		return maSinhVien;
	}
	/**
	 * @param maSinhVien the maSinhVien to set
	 */
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	/**
	 * @return the hoDem
	 */
	public String getHoDem() {
		return hoDem;
	}
	/**
	 * @param hoDem the hoDem to set
	 */
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	/**
	 * @return the gioiTinh
	 */
	public int getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the cmtnd
	 */
	public String getCmtnd() {
		return cmtnd;
	}
	/**
	 * @param cmtnd the cmtnd to set
	 */
	public void setCmtnd(String cmtnd) {
		this.cmtnd = cmtnd;
	}
	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}
	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	/**
	 * @return the noiSinh
	 */
	public String getNoiSinh() {
		return noiSinh;
	}
	/**
	 * @param noiSinh the noiSinh to set
	 */
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	/**
	 * @return the queQuan
	 */
	public String getQueQuan() {
		return queQuan;
	}
	/**
	 * @param queQuan the queQuan to set
	 */
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	/**
	 * @return the hoKhauThuongTru
	 */
	public String getHoKhauThuongTru() {
		return hoKhauThuongTru;
	}
	/**
	 * @param hoKhauThuongTru the hoKhauThuongTru to set
	 */
	public void setHoKhauThuongTru(String hoKhauThuongTru) {
		this.hoKhauThuongTru = hoKhauThuongTru;
	}
	/**
	 * @return the noiOHienTai
	 */
	public String getNoiOHienTai() {
		return noiOHienTai;
	}
	/**
	 * @param noiOHienTai the noiOHienTai to set
	 */
	public void setNoiOHienTai(String noiOHienTai) {
		this.noiOHienTai = noiOHienTai;
	}
	/**
	 * @return the cheDoUuDai
	 */
	public String getCheDoUuDai() {
		return cheDoUuDai;
	}
	/**
	 * @param cheDoUuDai the cheDoUuDai to set
	 */
	public void setCheDoUuDai(String cheDoUuDai) {
		this.cheDoUuDai = cheDoUuDai;
	}
	/**
	 * @return the danTocId
	 */
	public int getDanTocId() {
		return danTocId;
	}
	/**
	 * @param danTocId the danTocId to set
	 */
	public void setDanTocId(int danTocId) {
		this.danTocId = danTocId;
	}
	/**
	 * @return the tonGiaoId
	 */
	public int getTonGiaoId() {
		return tonGiaoId;
	}
	/**
	 * @param tonGiaoId the tonGiaoId to set
	 */
	public void setTonGiaoId(int tonGiaoId) {
		this.tonGiaoId = tonGiaoId;
	}
	/**
	 * @return the quocTichId
	 */
	public int getQuocTichId() {
		return quocTichId;
	}
	/**
	 * @param quocTichId the quocTichId to set
	 */
	public void setQuocTichId(int quocTichId) {
		this.quocTichId = quocTichId;
	}
	/**
	 * @return the hoTenBo
	 */
	public String getHoTenBo() {
		return hoTenBo;
	}
	/**
	 * @param hoTenBo the hoTenBo to set
	 */
	public void setHoTenBo(String hoTenBo) {
		this.hoTenBo = hoTenBo;
	}
	/**
	 * @return the ngheNghiepBo
	 */
	public String getNgheNghiepBo() {
		return ngheNghiepBo;
	}
	/**
	 * @param ngheNghiepBo the ngheNghiepBo to set
	 */
	public void setNgheNghiepBo(String ngheNghiepBo) {
		this.ngheNghiepBo = ngheNghiepBo;
	}
	/**
	 * @return the hoTenMe
	 */
	public String getHoTenMe() {
		return hoTenMe;
	}
	/**
	 * @param hoTenMe the hoTenMe to set
	 */
	public void setHoTenMe(String hoTenMe) {
		this.hoTenMe = hoTenMe;
	}
	/**
	 * @return the ngheNghiepMe
	 */
	public String getNgheNghiepMe() {
		return ngheNghiepMe;
	}
	/**
	 * @param ngheNghiepMe the ngheNghiepMe to set
	 */
	public void setNgheNghiepMe(String ngheNghiepMe) {
		this.ngheNghiepMe = ngheNghiepMe;
	}
	/**
	 * @return the heDtId
	 */
	public int getHeDtId() {
		return heDtId;
	}
	/**
	 * @param heDtId the heDtId to set
	 */
	public void setHeDtId(int heDtId) {
		this.heDtId = heDtId;
	}
	/**
	 * @return the lopId
	 */
	public int getLopId() {
		return lopId;
	}
	/**
	 * @param lopId the lopId to set
	 */
	public void setLopId(int lopId) {
		this.lopId = lopId;
	}
	/**
	 * @return the khoaHocId
	 */
	public int getKhoaHocId() {
		return khoaHocId;
	}
	/**
	 * @param khoaHocId the khoaHocId to set
	 */
	public void setKhoaHocId(int khoaHocId) {
		this.khoaHocId = khoaHocId;
	}
	/**
	 * @return the ngayNhapHoc
	 */
	public Date getNgayNhapHoc() {
		return ngayNhapHoc;
	}
	/**
	 * @param ngayNhapHoc the ngayNhapHoc to set
	 */
	public void setNgayNhapHoc(Date ngayNhapHoc) {
		this.ngayNhapHoc = ngayNhapHoc;
	}
	/**
	 * @return the diemDauVao1
	 */
	public float getDiemDauVao1() {
		return diemDauVao1;
	}
	/**
	 * @param diemDauVao1 the diemDauVao1 to set
	 */
	public void setDiemDauVao1(float diemDauVao1) {
		this.diemDauVao1 = diemDauVao1;
	}
	/**
	 * @return the diemDauVao2
	 */
	public float getDiemDauVao2() {
		return diemDauVao2;
	}
	/**
	 * @param diemDauVao2 the diemDauVao2 to set
	 */
	public void setDiemDauVao2(float diemDauVao2) {
		this.diemDauVao2 = diemDauVao2;
	}
	/**
	 * @return the diemDauVao3
	 */
	public float getDiemDauVao3() {
		return diemDauVao3;
	}
	/**
	 * @param diemDauVao3 the diemDauVao3 to set
	 */
	public void setDiemDauVao3(float diemDauVao3) {
		this.diemDauVao3 = diemDauVao3;
	}

	/**
	 * @return the tenHeDaoTao
	 */
	public String getTenHeDaoTao() {
		return tenHeDaoTao;
	}

	/**
	 * @param tenHeDaoTao the tenHeDaoTao to set
	 */
	public void setTenHeDaoTao(String tenHeDaoTao) {
		this.tenHeDaoTao = tenHeDaoTao;
	}

	/**
	 * @return the tenLopHoc
	 */
	public String getTenLopHoc() {
		return tenLopHoc;
	}

	/**
	 * @param tenLopHoc the tenLopHoc to set
	 */
	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	/**
	 * @return the tenKhoaHoc
	 */
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	/**
	 * @param tenKhoaHoc the tenKhoaHoc to set
	 */
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	/**
	 * @return the maHeDaoTao
	 */
	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}

	/**
	 * @param maHeDaoTao the maHeDaoTao to set
	 */
	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}
}
