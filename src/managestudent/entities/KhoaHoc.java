/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHoc.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class KhoaHoc {
	private int khoaHocId;
	private String tenKhoaHoc;

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public KhoaHoc() {
		khoaHocId = -1;
		tenKhoaHoc = "";
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param khoaHocId int khóa học id
	 * @param tenKhoaHoc String tên khóa học
	 */
	public KhoaHoc(int khoaHocId, String tenKhoaHoc) {
		this.khoaHocId = khoaHocId;
		this.tenKhoaHoc = tenKhoaHoc;
	}

	/**
	 * Constructor không có khóa học id
	 *
	 * @param tenKhoaHoc String tên khóa học
	 */
	public KhoaHoc(String tenKhoaHoc) {
		this.khoaHocId = -1;
		this.tenKhoaHoc = tenKhoaHoc;
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
}
