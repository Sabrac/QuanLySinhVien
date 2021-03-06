/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHocLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.KhoaHoc;

/**
 *
 * @author HaVH
 *
 */
public interface KhoaHocLogics {
	/**
	 * Lấy danh sách tất cả khóa học
	 *
	 * @return List<KhoaHoc> Danh sách đối tượng khóa học
	 */
	List<KhoaHoc> getAllKhoaHoc(KhoaHoc khoaHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin khóa học bằng khóa học id
	 *
	 * @param khoaHocId int khóa học id
	 * @return KhoaHoc đối tượng khóa học
	 */
	KhoaHoc getKhoaHocById(int khoaHocId);

	/**
	 * Thêm khóa học
	 *
	 * @param khoaHoc KhoaHoc đối tượng khóa học
	 * @return true: thành công / false: thất bại
	 */
	boolean addKhoaHoc(KhoaHoc khoaHoc);

	/**
	 * Cập nhật thông tin khóa học
	 *
	 * @param khoaHocId int khóa học id
	 * @param khoaHoc KhoaHoc đối tượng khóa học
	 * @return true: thành công / false: thất bại
	 */
	boolean updateKhoaHocById(int khoaHocId, KhoaHoc khoaHoc);

	/**
	 * Xóa thông tin khóa học
	 *
	 * @param khoaHocId int khóa học id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteKhoaHocById(int khoaHocId);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();

	/**
	 * Lấy toàn bộ số bản ghi trong bảng
	 *
	 * @return int tổng số bản ghi
	 */
	int getTotalRecords(KhoaHoc khoaHoc);
}
