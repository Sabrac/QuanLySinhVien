/**
 * Copyright(C) K16SE 2014
 *
 * Nganh.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class Nganh {
	private int nganhId;
	private String maNganh;
	private String tenNganh;
	private String ghiChu;

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
	/**
	 * @return the maNganh
	 */
	public String getMaNganh() {
		return maNganh;
	}
	/**
	 * @param maNganh the maNganh to set
	 */
	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}
	/**
	 * @return the tenNganh
	 */
	public String getTenNganh() {
		return tenNganh;
	}
	/**
	 * @param tenNganh the tenNganh to set
	 */
	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}
	/**
	 * @return the ghiChu
	 */
	public String getGhiChu() {
		return ghiChu;
	}
	/**
	 * @param ghiChu the ghiChu to set
	 */
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
