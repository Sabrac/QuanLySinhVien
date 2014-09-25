/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHocDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.KhoaHoc;

/**
 *
 * @author HaVH
 *
 */
public interface KhoaHocDao extends BaseDao {
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
	 * Lấy tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 *
	 * @param khoaHoc KhoaHoc đối tượng khóa học (chứa thông tin điều kiện tìm kiếm)
	 * @return int tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 */
	int getTotalRecords(KhoaHoc khoaHoc);
}
