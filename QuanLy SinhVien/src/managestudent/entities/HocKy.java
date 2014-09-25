/**
 * Copyright(C) K16SE 2014
 *
 * HocKy.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class HocKy {
	private int hocKyId;
	private String tenHocKy;

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public HocKy() {
		hocKyId = -1;
		tenHocKy = "";
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param hocKyId int học kỳ id
	 * @param tenHocKy String tên học kỳ
	 */
	public HocKy(int hocKyId, String tenHocKy) {
		this.hocKyId = hocKyId;
		this.tenHocKy = tenHocKy;
	}

	/**
	 * Constructor không có học kỳ id
	 *
	 * @param tenHocKy String tên học kỳ
	 */
	public HocKy(String tenHocKy) {
		this.hocKyId = -1;
		this.tenHocKy = tenHocKy;
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
	/**
	 * @return the tenHocKy
	 */
	public String getTenHocKy() {
		return tenHocKy;
	}
	/**
	 * @param tenHocKy the tenHocKy to set
	 */
	public void setTenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}
}
