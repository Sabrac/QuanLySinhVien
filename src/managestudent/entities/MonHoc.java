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
