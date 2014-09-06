/**
 * Copyright(C) K16SE 2014
 *
 * MonHoc.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class MonHoc {
	private int monHocId;
	private String tenMonHoc;
	private String soTrinh;
	private float heSoChuyenCan;
	private float heSoGiuaKy;
	private float heSoHocKy;
	private int tinhTrang;
	private int chuyenNganhId;
	private int soNgayNghi;

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public MonHoc() {
		monHocId = -1;
		tenMonHoc = "";
		soTrinh = "";
		heSoChuyenCan = -1;
		heSoGiuaKy = -1;
		heSoHocKy = -1;
		tinhTrang = -1;
		chuyenNganhId = -1;
		soNgayNghi = -1;
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param monHocId int môn học id
	 * @param tenMonHoc String tên môn học
	 * @param soTrinh String số trình
	 * @param heSoChuyenCan float hệ số chuyên cần
	 * @param heSoGiuaKy float hệ số giữa kỳ
	 * @param heSoHocKy float hệ số học kỳ
	 * @param tinhTrang int tình trạng
	 * @param chuyenNganhId int chuyên ngành id
	 * @param soNgayNghi int số ngày nghỉ
	 */
	public MonHoc(int monHocId, String tenMonHoc, String soTrinh, float heSoChuyenCan, float heSoGiuaKy, float heSoHocKy, int tinhTrang, int chuyenNganhId, int soNgayNghi) {
		this.monHocId = monHocId;
		this.tenMonHoc = tenMonHoc;
		this.soTrinh = soTrinh;
		this.heSoChuyenCan = heSoChuyenCan;
		this.heSoGiuaKy = heSoGiuaKy;
		this.heSoHocKy = heSoHocKy;
		this.tinhTrang = tinhTrang;
		this.chuyenNganhId = chuyenNganhId;
		this.soNgayNghi = soNgayNghi;
	}

	/**
	 * Constructor không có id môn học
	 *
	 * @param tenMonHoc String tên môn học
	 * @param soTrinh String số trình
	 * @param heSoChuyenCan float hệ số chuyên cần
	 * @param heSoGiuaKy float hệ số giữa kỳ
	 * @param heSoHocKy float hệ số học kỳ
	 * @param tinhTrang int tình trạng
	 * @param chuyenNganhId int chuyên ngành id
	 * @param soNgayNghi int số ngày nghỉ
	 */
	public MonHoc(String tenMonHoc, String soTrinh, float heSoChuyenCan, float heSoGiuaKy, float heSoHocKy, int tinhTrang, int chuyenNganhId, int soNgayNghi) {
		this.monHocId = -1;
		this.tenMonHoc = tenMonHoc;
		this.soTrinh = soTrinh;
		this.heSoChuyenCan = heSoChuyenCan;
		this.heSoGiuaKy = heSoGiuaKy;
		this.heSoHocKy = heSoHocKy;
		this.tinhTrang = tinhTrang;
		this.chuyenNganhId = chuyenNganhId;
		this.soNgayNghi = soNgayNghi;
	}

	/**
	 * @return the soNgayNghi
	 */
	public int getSoNgayNghi() {
		return soNgayNghi;
	}
	/**
	 * @param soNgayNghi the soNgayNghi to set
	 */
	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
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
	 * @return the monHocId
	 */
	public int getMonHocId() {
		return monHocId;
	}
	/**
	 * @param monHocId the monHocId to set
	 */
	public void setMonHocId(int monHocId) {
		this.monHocId = monHocId;
	}
	/**
	 * @return the tenMonHoc
	 */
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	/**
	 * @param tenMonHoc the tenMonHoc to set
	 */
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	/**
	 * @return the soTrinh
	 */
	public String getSoTrinh() {
		return soTrinh;
	}
	/**
	 * @param soTrinh the soTrinh to set
	 */
	public void setSoTrinh(String soTrinh) {
		this.soTrinh = soTrinh;
	}
	/**
	 * @return the heSoChuyenCan
	 */
	public float getHeSoChuyenCan() {
		return heSoChuyenCan;
	}
	/**
	 * @param heSoChuyenCan the heSoChuyenCan to set
	 */
	public void setHeSoChuyenCan(float heSoChuyenCan) {
		this.heSoChuyenCan = heSoChuyenCan;
	}
	/**
	 * @return the heSoGiuaKy
	 */
	public float getHeSoGiuaKy() {
		return heSoGiuaKy;
	}
	/**
	 * @param heSoGiuaKy the heSoGiuaKy to set
	 */
	public void setHeSoGiuaKy(float heSoGiuaKy) {
		this.heSoGiuaKy = heSoGiuaKy;
	}
	/**
	 * @return the heSoHocKy
	 */
	public float getHeSoHocKy() {
		return heSoHocKy;
	}
	/**
	 * @param heSoHocKy the heSoHocKy to set
	 */
	public void setHeSoHocKy(float heSoHocKy) {
		this.heSoHocKy = heSoHocKy;
	}
	/**
	 * @return the tinhTrang
	 */
	public int getTinhTrang() {
		return tinhTrang;
	}
	/**
	 * @param tinhTrang the tinhTrang to set
	 */
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
