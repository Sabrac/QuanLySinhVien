/**
 * Copyright(C) K16SE 2014
 *
 * MonHocLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.MonHoc;

/**
 *
 * @author HaVH
 *
 */
public interface MonHocLogics {
	/**
	 * Lấy danh sách tất cả môn học
	 *
	 * @return List<MonHoc> danh sách đối tượng môn học
	 */
	List<MonHoc> getAllMonHoc(MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin môn học bằng id môn học
	 *
	 * @param monHocId int môn học id
	 * @return MonHoc đối tượng môn học
	 */
	MonHoc getMonHocById(int monHocId);

	/**
	 * Lấy thông tin môn học bằng chuyên ngành id
	 *
	 * @param chuyenNganhId int chuyên ngành id
	 * @return List<MonHoc> Danh sách đối tượng môn học
	 */
	List<MonHoc> getMonHocByChuyenNganh(int chuyenNganhId, MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Thêm môn học
	 *
	 * @param monHoc MonHoc đối tượng môn học
	 * @return true: thành công / false: thất bại
	 */
	boolean addMonHoc(MonHoc monHoc);

	/**
	 * Cập nhật thông tin môn học bằng id môn học
	 *
	 * @param monHocId int id môn học
	 * @param monHoc MonHoc đối tượng môn học
	 * @return true: thành công / false: thất bại
	 */
	boolean updateMonHocById(int monHocId, MonHoc monHoc);

	/**
	 * Xóa thông tin môn học
	 *
	 * @param monHocId int id môn học
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteMonHocById(int monHocId);

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
	int getTotalRecords(MonHoc monHoc);
}
