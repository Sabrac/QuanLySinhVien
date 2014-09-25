/**
 * Copyright(C) K16SE 2014
 *
 * LopHoc.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class LopHoc {
	private int lopHocId;
	private String tenLopHoc;

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public LopHoc() {
		lopHocId = -1;
		tenLopHoc = "";
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param lopHocId int lớp học id
	 * @param tenLopHoc String tên lớp học
	 */
	public LopHoc(int lopHocId, String tenLopHoc) {
		this.lopHocId = lopHocId;
		this.tenLopHoc = tenLopHoc;
	}

	/**
	 * Constructor không có lớp học id
	 *
	 * @param tenLopHoc String tên lớp học
	 */
	public LopHoc(String tenLopHoc) {
		this.lopHocId = -1;
		this.tenLopHoc = tenLopHoc;
	}

	/**
	 * @return the lopHocId
	 */
	public int getLopHocId() {
		return lopHocId;
	}
	/**
	 * @param lopHocId the lopHocId to set
	 */
	public void setLopHocId(int lopHocId) {
		this.lopHocId = lopHocId;
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
}
