/**
 * Copyright(C) K16SE 2014
 *
 * LopHocLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.LopHoc;

/**
 *
 * @author HaVH
 *
 */
public interface LopHocLogics {
	/**
	 * Lấy danh sách lớp học
	 *
	 * @return List<LopHoc> Danh sách đối tượng lớp học
	 */
	List<LopHoc> getAllLopHoc();

	/**
	 * Lấy thông tin lớp học bằng lớp học id
	 *
	 * @param lopHocId int lớp học id
	 * @return LopHoc đối tượng lớp học
	 */
	LopHoc getLopHocById(int lopHocId);

	/**
	 * Thêm lớp học
	 *
	 * @param lopHoc LopHoc đối tượng lớp học
	 * @return true: thành công / false: thất bại
	 */
	boolean addLopHoc(LopHoc lopHoc);

	/**
	 * Cập nhật thông tin lớp học
	 *
	 * @param lopHocId int lớp học id
	 * @param lopHoc LopHoc đối tượng lớp học
	 * @return true: thành công / false: thất bại
	 */
	boolean updateLopHocById(int lopHocId, LopHoc lopHoc);

	/**
	 * Xóa thông tin lớp học
	 *
	 * @param lopHocId int lớp học id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteLopHocById(int lopHocId);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();
}
