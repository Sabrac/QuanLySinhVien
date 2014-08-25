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
	private boolean gioiTinh; //true: Nam / false: Nu
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
	private int chuyenNganhId;
	private int lopId;
	private int khoaHocId;
	private Date ngayNhapHoc;
	private String diemDauVao1;
	private String diemDauVao2;
	private String diemDauVao3;
	private int diemId;

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
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
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
	 * @return the chuyenNganhId
	 */
	public int getChuyenNganhId() {
		return chuyenNganhId;
	}
	/**
	 * @param chuyenNganhId the chuyenNganhId to set
	 */
	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
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
	public String getDiemDauVao1() {
		return diemDauVao1;
	}
	/**
	 * @param diemDauVao1 the diemDauVao1 to set
	 */
	public void setDiemDauVao1(String diemDauVao1) {
		this.diemDauVao1 = diemDauVao1;
	}
	/**
	 * @return the diemDauVao2
	 */
	public String getDiemDauVao2() {
		return diemDauVao2;
	}
	/**
	 * @param diemDauVao2 the diemDauVao2 to set
	 */
	public void setDiemDauVao2(String diemDauVao2) {
		this.diemDauVao2 = diemDauVao2;
	}
	/**
	 * @return the diemDauVao3
	 */
	public String getDiemDauVao3() {
		return diemDauVao3;
	}
	/**
	 * @param diemDauVao3 the diemDauVao3 to set
	 */
	public void setDiemDauVao3(String diemDauVao3) {
		this.diemDauVao3 = diemDauVao3;
	}
	/**
	 * @return the diemId
	 */
	public int getDiemId() {
		return diemId;
	}
	/**
	 * @param diemId the diemId to set
	 */
	public void setDiemId(int diemId) {
		this.diemId = diemId;
	}
}
