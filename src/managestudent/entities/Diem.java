/**
 * Copyright(C) K16SE 2014
 *
 * Diem.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class Diem {
	private int diemId;
	private int monHocId;
	private String lanThi;
	private float diemThi;
	private float diemChuyenCan;
	private float diemGiuaKy;
	private int hocKyId;
	private int sinhVienId;

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
	 * @return the lanThi
	 */
	public String getLanThi() {
		return lanThi;
	}
	/**
	 * @param lanThi the lanThi to set
	 */
	public void setLanThi(String lanThi) {
		this.lanThi = lanThi;
	}
	/**
	 * @return the diemThi
	 */
	public float getDiemThi() {
		return diemThi;
	}
	/**
	 * @param diemThi the diemThi to set
	 */
	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}
	/**
	 * @return the diemChuyenCan
	 */
	public float getDiemChuyenCan() {
		return diemChuyenCan;
	}
	/**
	 * @param diemChuyenCan the diemChuyenCan to set
	 */
	public void setDiemChuyenCan(float diemChuyenCan) {
		this.diemChuyenCan = diemChuyenCan;
	}
	/**
	 * @return the diemGiuaKy
	 */
	public float getDiemGiuaKy() {
		return diemGiuaKy;
	}
	/**
	 * @param diemGiuaKy the diemGiuaKy to set
	 */
	public void setDiemGiuaKy(float diemGiuaKy) {
		this.diemGiuaKy = diemGiuaKy;
	}
	/**
	 * @return the hocKyId
	 */
	public int getHocKyId() {
		return hocKyId;
	}
	/**
	 * @param hocKyId the hocKyId to set
	 */
	public void setHocKyId(int hocKyId) {
		this.hocKyId = hocKyId;
	}
}
