/**
 * Copyright(C) K16SE 2014
 *
 * ChuyenNganh.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class ChuyenNganh {
	private int chuyenNganhId;
	private String maChuyenNganh;
	private String tenChuyenNganh;
	private int nganhId;

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param chuyenNganhId int id chuyên ngành
	 * @param maChuyenNganh String mã chuyên ngành
	 * @param tenChuyenNganh String tên chuyên ngành
	 * @param nganhId int id ngành
	 */
	public ChuyenNganh(int chuyenNganhId, String maChuyenNganh, String tenChuyenNganh, int nganhId) {
		this.chuyenNganhId = chuyenNganhId;
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
		this.nganhId = nganhId;
	}

	/**
	 * Constructor không có chuyenNganhId
	 *
	 * @param maChuyenNganh String mã chuyên ngành
	 * @param tenChuyenNganh String tên chuyên ngành
	 * @param nganhId int id ngành
	 */
	public ChuyenNganh(String maChuyenNganh, String tenChuyenNganh, int nganhId) {
		this.chuyenNganhId = -1;
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
		this.nganhId = nganhId;
	}

	/**
	 * Constructor không tham số
	 *
	 */
	public ChuyenNganh() {
		this.chuyenNganhId = -1;
		this.maChuyenNganh = "";
		this.tenChuyenNganh = "";
		this.nganhId = -1;
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
	 * @return the maChuyenNganh
	 */
	public String getMaChuyenNganh() {
		return maChuyenNganh;
	}
	/**
	 * @param maChuyenNganh the maChuyenNganh to set
	 */
	public void setMaChuyenNganh(String maChuyenNganh) {
		this.maChuyenNganh = maChuyenNganh;
	}
	/**
	 * @return the tenChuyenNganh
	 */
	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}
	/**
	 * @param tenChuyenNganh the tenChuyenNganh to set
	 */
	public void setTenChuyenNganh(String tenChuyenNganh) {
		tenChuyenNganh = tenChuyenNganh;
	}
	/**
	 * @return the nganhId
	 */
	public int getNganhId() {
		return nganhId;
	}
	/**
	 * @param nganhId the nganhId to set
	 */
	public void setNganhId(int nganhId) {
		this.nganhId = nganhId;
	}
}
