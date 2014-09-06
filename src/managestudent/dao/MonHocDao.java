/**
 * Copyright(C) K16SE 2014
 *
 * MonHocDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.MonHoc;

/**
 *
 * @author HaVH
 *
 */
/**
 *
 * @author HaVH
 *
 */
public interface MonHocDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả môn học
	 *
	 * @return List<MonHoc> danh sách đối tượng môn học
	 */
	List<MonHoc> getAllMonHoc();

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
	 * @return MonHoc đối tượng môn học
	 */
	MonHoc getMonHocByChuyenNganh(int chuyenNganhId);

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
}
